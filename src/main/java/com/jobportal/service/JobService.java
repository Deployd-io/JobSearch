package com.jobportal.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.dao.JobDAO;
import com.jobportal.dto.JobContactViewDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.dto.LocationDTO;
import com.jobportal.model.Job;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JobService {
	
	@Autowired
	JobDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ModelMapperService modelMapperService;

	@Autowired
	ProposalService proposalService;
	
	
	public List<JobDTO> findAll()
	{
		log.debug(">>> Entering findAll()");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}
	
	public JobDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(id);
		
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
			log.debug("findById(id={}): optJob → {}", id, optJob);
		log.debug("<<< Exiting findById(id={})", id);
		if (!optJob.isPresent()) {
			return null;
		}
		
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		long start = System.currentTimeMillis();
		List jobs1 = dao.findByContactEmail(contactEmail);
		
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		
		// fill in the proposal details
		jobs.forEach(job -> {
			job.setProposals(proposalService.findByJobId(job.getJobId()));
		});
		
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		return jobs;
	}
	
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		Job job = modelMapper.map(jobDTO, Job.class);
		job.setCreatedOn((new Date()).toString());
		job.setUpdatedOn(job.getCreatedOn());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		
		long start = System.currentTimeMillis();
		log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		dao.save(job);
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		
		return job.getJobId();
	}
	
	
	@Transactional
	public void updateJob(JobDTO jobDTO)
	{
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		
			log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		if (!optJob.isPresent()) {
			return;
		}
		
		Job job = optJob.get();
		job.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(jobDTO, job);
		
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		dao.save(job);
	}
	
	@Transactional
	public void updateLocation(String jobId, LocationDTO location)
	{
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobId);
		
			log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		if (!optJob.isPresent()) {
			return;
		}
		
		Job job = optJob.get();
		Point point = new Point(location.getLongitude(), location.getLatitude());
		
		job.setPoint(point);

		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		dao.save(job);
	}

	// --- Error simulation: NumberFormatException ---
	public String parseJobBudget(String rawBudget)
	{
		try {
			int budget = Integer.parseInt(rawBudget);
			return "budget=" + budget;
		} catch (Exception e) {
			return "parseJobBudget failed: " + e.getMessage();
		}
	}
}
