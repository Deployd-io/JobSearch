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
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}
	
	public JobDTO findById(String id)
	{
		log.debug(">>> Entering findById(String id={})", String id);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(id);
		log.debug("findById(String id={}): optJob → {}", String id, optJob);
		long start = System.currentTimeMillis();
		log.info("findById(String id)={}: find query executed in {} ms", String id, (System.currentTimeMillis() - start));
		
		if (!optJob.isPresent())
			return null;
		
		log.debug("<<< Exiting findById(String id={})", String id);
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
		log.debug(">>> Entering findByContactEmail(String contactEmail={})", String contactEmail);
		long start = System.currentTimeMillis();
		List jobs1 = dao.findByContactEmail(contactEmail);
		log.debug("findByContactEmail(String contactEmail={}): jobs1 → {}", String contactEmail, jobs1);
		long start = System.currentTimeMillis();
		
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.info("findByContactEmail(String contactEmail)={}: find query executed in {} ms", String contactEmail, (System.currentTimeMillis() - start));
		
		// fill in the proposal details
		jobs.forEach(job -> {
			log.debug("<<< Exiting findByContactEmail(String contactEmail={})", String contactEmail);
			job.setProposals(proposalService.findByJobId(job.getJobId()));
			log.debug("findByContactEmail(String contactEmail={}): job → {}", String contactEmail, job);
		});
		
		return jobs;
	}
	
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		long start = System.currentTimeMillis();
		Job job = modelMapper.map(jobDTO, Job.class);
		log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		long start = System.currentTimeMillis();
		job.setCreatedOn((new Date()).toString());
		job.setUpdatedOn(job.getCreatedOn());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		log.debug("createJob(JobDTO jobDTO={}): point → {}", JobDTO jobDTO, point);
		job.setPoint(point);
		
		dao.save(job);
		log.info("createJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		
		return job.getJobId();
	}
	
	
	@Transactional
	public void updateJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering updateJob(JobDTO jobDTO={})", JobDTO jobDTO);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		log.debug("updateJob(JobDTO jobDTO={}): optJob → {}", JobDTO jobDTO, optJob);
		long start = System.currentTimeMillis();
		log.info("updateJob(JobDTO jobDTO)={}: find query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
		
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		job.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		log.debug("updateJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		
		modelMapperService.getNonNullModelMapper().map(jobDTO, job);
		
		dao.save(job);
		log.info("updateJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
	}
	
	@Transactional
	public void updateLocation(String jobId, LocationDTO location)
	{
		log.debug(">>> Entering updateLocation(String jobId={},LocationDTO location={})", String jobId, LocationDTO location);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobId);
		log.debug("updateLocation(String jobId={},LocationDTO location={}): optJob → {}", String jobId, LocationDTO location, optJob);
		long start = System.currentTimeMillis();
		log.info("updateLocation(String jobId,LocationDTO location)={},{}: find query executed in {} ms", String jobId, LocationDTO location, (System.currentTimeMillis() - start));
		
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		Point point = new Point(location.getLongitude(), location.getLatitude());
		
		job.setPoint(point);
		log.debug("updateLocation(String jobId={},LocationDTO location={}): job → {}", String jobId, LocationDTO location, job);
		
		dao.save(job);
		log.info("updateLocation(String jobId,LocationDTO location)={},{}: save query executed in {} ms", String jobId, LocationDTO location, (System.currentTimeMillis() - start));
	}
}
