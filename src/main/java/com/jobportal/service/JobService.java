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
import lombok.extern.slf4j.Slf4j;
import com.jobportal.model.Job;

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
		long start = System.currentTimeMillis();
		log.info("findAll()=): query {} executed in {} ms", , query, (System.currentTimeMillis() - start));
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}
	
	public JobDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		Optional<Job> optJob = dao.findById(id);
		long start = System.currentTimeMillis();
		
		log.info("findById(id)={}): query {} executed in {} ms", id, query, (System.currentTimeMillis() - start));
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
		
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.info("findByContactEmail(contactEmail)={}): query {} executed in {} ms", contactEmail, query, (System.currentTimeMillis() - start));
		
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
		job.setCreatedOn((new Date()).toString());
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		job.setUpdatedOn(job.getCreatedOn());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		
		dao.save(job);
		
		log.info("createJob(jobDTO)={}): query {} executed in {} ms", jobDTO, query, (System.currentTimeMillis() - start));
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
		
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		job.setUpdatedOn((new Date()).toString());
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(jobDTO, job);
		
		dao.save(job);
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
	}
	log.info("updateJob(jobDTO)={}): query {} executed in {} ms", jobDTO, query, (System.currentTimeMillis() - start));
	
	@Transactional
	public void updateLocation(String jobId, LocationDTO location)
	{
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		Optional<Job> optJob = dao.findById(jobId);
		long start = System.currentTimeMillis();
		
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		Point point = new Point(location.getLongitude(), location.getLatitude());
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		
		job.setPoint(point);
		
		dao.save(job);
		log.debug("<<< Exiting updateLocation(jobId={},location={})", jobId, location);
	}
	log.info("updateLocation(jobId,location)={},{}): query {} executed in {} ms", jobId, location, query, (System.currentTimeMillis() - start));
}
