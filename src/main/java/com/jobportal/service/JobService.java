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
	LocationService locationService;
	
	@Autowired
	ProposalService proposalService;
	
	
	public List<JobDTO> findAll()
	{
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}
	
	public JobDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		Optional<Job> optJob = dao.findById(id);
		long start = System.currentTimeMillis();
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		log.debug("findById(id={}): optJob → {}", id, optJob);
		
		if (!optJob.isPresent())
			return null;
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		List jobs1 = dao.findByContactEmail(contactEmail);
		long start = System.currentTimeMillis();
		log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		
		// fill in the proposal details
		jobs.forEach(job -> {
			job.setProposals(proposalService.findByJobId(job.getJobId()));
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
		});
		
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		return jobs;
	}
	
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		Job job = modelMapper.map(jobDTO, Job.class);
		long start = System.currentTimeMillis();
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		job.setCreatedOn((new Date()).toString());
		job.setUpdatedOn(job.getCreatedOn());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		job.setPoint(point);
		
		dao.save(job);
		log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		return job.getJobId();
	}
	
	
	@Transactional
	public void updateJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		long start = System.currentTimeMillis();
		log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		job.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		log.debug("updateJob(jobDTO={}): point → {}", jobDTO, point);
		job.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(jobDTO, job);
		
		dao.save(job);
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
	}
	
	@Transactional
	public void updateLocation(String jobId, LocationDTO location)
	{
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		Optional<Job> optJob = dao.findById(jobId);
		long start = System.currentTimeMillis();
		log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
		
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		Point point = new Point(location.getLongitude(), location.getLatitude());
		log.debug("updateLocation(jobId={},location={}): point → {}", jobId, location, point);
		
		job.setPoint(point);
		
		dao.save(job);
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateLocation(jobId={},location={})", jobId, location);
	}
}
