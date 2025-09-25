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
		log.debug("<<< Exiting findAll()");
		log.info("findAll(): find operation executed in {} ms", (System.currentTimeMillis() - start));
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}
	
	public JobDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		Optional<Job> optJob = dao.findById(id);
		
		log.info("findById(id={}): find operation executed in {} ms", id, (System.currentTimeMillis() - start));
		if (!optJob.isPresent())
			return null;
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		List jobs1 = dao.findByContactEmail(contactEmail);
		
		log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
		
		// fill in the proposal details
		jobs.forEach(job -> {
			job.setProposals(proposalService.findByJobId(job.getJobId()));
		});
		log.info("findByContactEmail(contactEmail={}): find operation executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		
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
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		
		dao.save(job);
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		
		log.info("createJob(jobDTO={}): find operation executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		return job.getJobId();
	}
	
	
	@Transactional
	public void updateJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		job.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		log.debug("updateJob(jobDTO={}): point → {}", jobDTO, point);
		
		modelMapperService.getNonNullModelMapper().map(jobDTO, job);
		
		dao.save(job);
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
	}
	log.info("updateJob(jobDTO={}): save operation executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
	
	@Transactional
	public void updateLocation(String jobId, LocationDTO location)
	{
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		Optional<Job> optJob = dao.findById(jobId);
		
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		Point point = new Point(location.getLongitude(), location.getLatitude());
		
		log.debug("updateLocation(jobId={},location={}): point → {}", jobId, location, point);
		job.setPoint(point);
		
		dao.save(job);
		log.debug("<<< Exiting updateLocation(jobId={},location={})", jobId, location);
	}
	log.info("updateLocation(jobId={}, location={}): save operation executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
}
