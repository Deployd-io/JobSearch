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
	
	// Simple logger wrapper to provide a log method
	private static final SimpleLogger logger = new SimpleLogger();
	
	private static class SimpleLogger {
		void log(String message) {
			// Simple implementation; could delegate to SLF4J if desired
			System.out.println(message);
		}
	}
	
	public List<JobDTO> findAll()
	{
		logger.log(">>> Entering findAll");
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		logger.log("<<< Exiting findAll");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}
	
	public JobDTO findById(String id)
	{
		logger.log(">>> Entering findById");
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(id);
		log.debug("findById(id={}): optJob → {}", id, optJob);
		long queryStart = System.currentTimeMillis();
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - queryStart));
		
		if (!optJob.isPresent()) {
			logger.log("<<< Exiting findById");
			return null;
		}
		
		logger.log("<<< Exiting findById");
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
		logger.log(">>> Entering findByContactEmail");
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		long start = System.currentTimeMillis();
		List jobs1 = dao.findByContactEmail(contactEmail);
		log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		long queryStart = System.currentTimeMillis();
		
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
		log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - queryStart));
		
		// fill in the proposal details
		jobs.forEach(job -> {
			job.setProposals(proposalService.findByJobId(job.getJobId()));
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
		});
		
		logger.log("<<< Exiting findByContactEmail");
		return jobs;
	}
	
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
		logger.log(">>> Entering createJob");
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		Job job = modelMapper.map(jobDTO, Job.class);
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		long saveStart = System.currentTimeMillis();
		job.setCreatedOn((new Date()).toString());
		job.setUpdatedOn(job.getCreatedOn());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		job.setPoint(point);
		
		dao.save(job);
		log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - saveStart));
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		logger.log("<<< Exiting createJob");
		return job.getJobId();
	}
	
	
	@Transactional
	public void updateJob(JobDTO jobDTO)
	{
		logger.log(">>> Entering updateJob");
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		long queryStart = System.currentTimeMillis();
		log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - queryStart));
		
		if (!optJob.isPresent()) {
			logger.log("<<< Exiting updateJob");
			return;
		}
		
		Job job = optJob.get();
		job.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		
		modelMapperService.getNonNullModelMapper().map(jobDTO, job);
		
		dao.save(job);
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		logger.log("<<< Exiting updateJob");
	}
	
	@Transactional
	public void updateLocation(String jobId, LocationDTO location)
	{
		logger.log(">>> Entering updateLocation");
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobId);
		log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
		long queryStart = System.currentTimeMillis();
		log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - queryStart));
		
		if (!optJob.isPresent()) {
			logger.log("<<< Exiting updateLocation");
			return;
		}
		
		Job job = optJob.get();
		Point point = new Point(location.getLongitude(), location.getLatitude());
		
		job.setPoint(point);
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		
		dao.save(job);
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		logger.log("<<< Exiting updateLocation");
	}
}