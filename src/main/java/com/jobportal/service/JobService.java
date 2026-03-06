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
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Slf4j
@Service
@Slf4j
public class JobService {
	
	@Autowired
	JobDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	log.debug(">>> Entering findAll()");
	
	@Autowired
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	ModelMapperService modelMapperService;

	long start = System.currentTimeMillis();
	log.debug(">>> Entering findById(String id={})", String id);
	log.debug(">>> Entering findAll()");
	@Autowired
	log.debug("findById(String id={}): optJob → {}", String id, optJob);
	long start = System.currentTimeMillis();
	ProposalService proposalService;
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findById(String id={})", String id);
	log.debug("<<< Exiting findById(String id={})", String id);
	log.debug(">>> Entering findAll()");
	
	log.debug("findById(String id={}): optJob → {}", String id, optJob);
	long start = System.currentTimeMillis();
	
	log.debug(">>> Entering findByContactEmail(String contactEmail={})", String contactEmail);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findById(String id={})", String id);
	log.debug("findByContactEmail(String contactEmail={}): jobs1 → {}", String contactEmail, jobs1);
	long start = System.currentTimeMillis();
	log.debug("<<< Exiting findById(String id={})", String id);
	log.debug(">>> Entering findAll()");
	public List<JobDTO> findAll()
	{
	log.debug("findById(String id={}): optJob → {}", String id, optJob);
	long start = System.currentTimeMillis();
		log.debug("findByContactEmail(String contactEmail={}): job → {}", String contactEmail, job);
		log.debug(">>> Entering findByContactEmail(String contactEmail={})", String contactEmail);
		log.debug("<<< Exiting findByContactEmail(String contactEmail={})", String contactEmail);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering findById(String id={})", String id);
		log.debug("findByContactEmail(String contactEmail={}): jobs1 → {}", String contactEmail, jobs1);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findById(String id={})", String id);
		log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering findAll()");
		log.debug(">>> Entering createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		log.debug("findById(String id={}): optJob → {}", String id, optJob);
		long start = System.currentTimeMillis();
		log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		log.debug("findByContactEmail(String contactEmail={}): job → {}", String contactEmail, job);
		log.debug(">>> Entering findByContactEmail(String contactEmail={})", String contactEmail);
		log.debug("<<< Exiting findByContactEmail(String contactEmail={})", String contactEmail);
		log.debug("createJob(JobDTO jobDTO={}): point → {}", JobDTO jobDTO, point);
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
			log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
			log.info("createJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
			log.debug("findByContactEmail(String contactEmail={}): jobs1 → {}", String contactEmail, jobs1);
			long start = System.currentTimeMillis();
			log.debug(">>> Entering findById(String id={})", String id);
			log.debug("<<< Exiting findById(String id={})", String id);
			log.debug("<<< Exiting createJob(JobDTO jobDTO={})", JobDTO jobDTO);
	}
	
	log.debug("findById(String id={}): optJob → {}", String id, optJob);
	log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	log.debug(">>> Entering updateJob(JobDTO jobDTO={})", JobDTO jobDTO);
	log.debug("findByContactEmail(String contactEmail={}): job → {}", String contactEmail, job);
	log.debug(">>> Entering findByContactEmail(String contactEmail={})", String contactEmail);
	log.debug("updateJob(JobDTO jobDTO={}): optJob → {}", JobDTO jobDTO, optJob);
	long start = System.currentTimeMillis();
	log.debug("<<< Exiting findByContactEmail(String contactEmail={})", String contactEmail);
	log.debug("createJob(JobDTO jobDTO={}): point → {}", JobDTO jobDTO, point);
	public JobDTO findById(String id)
	{
		log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		log.info("createJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
		log.debug(">>> Entering findById(String id={})", String id);
		long start = System.currentTimeMillis();
		log.debug("updateJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		Optional<Job> optJob = dao.findById(id);
		log.debug("<<< Exiting findById(String id={})", String id);
		log.debug("<<< Exiting createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		
		log.info("updateJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
		log.debug(">>> Entering createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		log.debug("findById(String id={}): optJob → {}", String id, optJob);
		long start = System.currentTimeMillis();
		log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering updateLocation(String jobId={},LocationDTO location={})", String jobId, LocationDTO location);
		log.debug(">>> Entering updateJob(JobDTO jobDTO={})", JobDTO jobDTO);
		log.debug("findByContactEmail(String contactEmail={}): job → {}", String contactEmail, job);
		if (!optJob.isPresent())
			log.info("updateLocation(String jobId,LocationDTO location)={},{}: find query executed in {} ms", String jobId, LocationDTO location, (System.currentTimeMillis() - start));
			long start = System.currentTimeMillis();
			log.debug("updateJob(JobDTO jobDTO={}): optJob → {}", JobDTO jobDTO, optJob);
			long start = System.currentTimeMillis();
			log.debug(">>> Entering findByContactEmail(String contactEmail={})", String contactEmail);
			log.debug("<<< Exiting findByContactEmail(String contactEmail={})", String contactEmail);
			log.debug("createJob(JobDTO jobDTO={}): point → {}", JobDTO jobDTO, point);
			return null;
		
		log.info("createJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
		log.info("updateLocation(String jobId,LocationDTO location)={},{}: save query executed in {} ms", String jobId, LocationDTO location, (System.currentTimeMillis() - start));
		log.debug("findByContactEmail(String contactEmail={}): jobs1 → {}", String contactEmail, jobs1);
		long start = System.currentTimeMillis();
		log.debug("updateJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		log.debug("<<< Exiting findById(String id={})", String id);
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	log.info("updateJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
	log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
	long start = System.currentTimeMillis();
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
		log.debug(">>> Entering updateJob(JobDTO jobDTO={})", JobDTO jobDTO);
		log.debug(">>> Entering updateLocation(String jobId={},LocationDTO location={})", String jobId, LocationDTO location);
		log.debug("findByContactEmail(String contactEmail={}): job → {}", String contactEmail, job);
		log.debug(">>> Entering findByContactEmail(String contactEmail={})", String contactEmail);
		log.debug("updateLocation(String jobId={},LocationDTO location={}): optJob → {}", String jobId, LocationDTO location, optJob);
		long start = System.currentTimeMillis();
		log.debug("updateJob(JobDTO jobDTO={}): optJob → {}", JobDTO jobDTO, optJob);
		long start = System.currentTimeMillis();
		log.debug("createJob(JobDTO jobDTO={}): point → {}", JobDTO jobDTO, point);
		List jobs1 = dao.findByContactEmail(contactEmail);
		
		log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		log.info("createJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
		log.debug("updateLocation(String jobId={},LocationDTO location={}): job → {}", String jobId, LocationDTO location, job);
		log.debug("<<< Exiting findByContactEmail(String contactEmail={})", String contactEmail);
		log.debug("findByContactEmail(String contactEmail={}): jobs1 → {}", String contactEmail, jobs1);
		log.info("updateLocation(String jobId,LocationDTO location)={},{}: save query executed in {} ms", String jobId, LocationDTO location, (System.currentTimeMillis() - start));
		long start = System.currentTimeMillis();
		log.debug("updateJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.debug("<<< Exiting createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		
		log.info("updateJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
		log.debug(">>> Entering createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		// fill in the proposal details
		jobs.forEach(job -> {
			log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
			log.debug(">>> Entering updateJob(JobDTO jobDTO={})", JobDTO jobDTO);
			log.debug(">>> Entering updateLocation(String jobId={},LocationDTO location={})", String jobId, LocationDTO location);
			long start = System.currentTimeMillis();
			job.setProposals(proposalService.findByJobId(job.getJobId()));
			log.debug("updateLocation(String jobId={},LocationDTO location={}): optJob → {}", String jobId, LocationDTO location, optJob);
			long start = System.currentTimeMillis();
			log.debug("updateJob(JobDTO jobDTO={}): optJob → {}", JobDTO jobDTO, optJob);
			long start = System.currentTimeMillis();
			log.debug("findByContactEmail(String contactEmail={}): job → {}", String contactEmail, job);
		});
		
		log.debug("createJob(JobDTO jobDTO={}): point → {}", JobDTO jobDTO, point);
		log.debug("<<< Exiting findByContactEmail(String contactEmail={})", String contactEmail);
		log.debug("updateLocation(String jobId={},LocationDTO location={}): job → {}", String jobId, LocationDTO location, job);
		return jobs;
	}
	log.info("updateLocation(String jobId,LocationDTO location)={},{}: save query executed in {} ms", String jobId, LocationDTO location, (System.currentTimeMillis() - start));
	log.info("createJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
	log.debug("updateJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
	
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
	log.info("updateJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		log.debug(">>> Entering createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		Job job = modelMapper.map(jobDTO, Job.class);
		job.setCreatedOn((new Date()).toString());
		log.debug("createJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		log.debug(">>> Entering updateLocation(String jobId={},LocationDTO location={})", String jobId, LocationDTO location);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering updateJob(JobDTO jobDTO={})", JobDTO jobDTO);
		log.debug("updateLocation(String jobId={},LocationDTO location={}): optJob → {}", String jobId, LocationDTO location, optJob);
		long start = System.currentTimeMillis();
		job.setUpdatedOn(job.getCreatedOn());
		
		log.debug("updateJob(JobDTO jobDTO={}): optJob → {}", JobDTO jobDTO, optJob);
		long start = System.currentTimeMillis();
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		log.debug("createJob(JobDTO jobDTO={}): point → {}", JobDTO jobDTO, point);
		log.debug("updateLocation(String jobId={},LocationDTO location={}): job → {}", String jobId, LocationDTO location, job);
		
		dao.save(job);
		log.info("updateLocation(String jobId,LocationDTO location)={},{}: save query executed in {} ms", String jobId, LocationDTO location, (System.currentTimeMillis() - start));
		log.info("createJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		log.debug("updateJob(JobDTO jobDTO={}): job → {}", JobDTO jobDTO, job);
		
		log.debug("<<< Exiting createJob(JobDTO jobDTO={})", JobDTO jobDTO);
		return job.getJobId();
	}
	log.info("updateJob(JobDTO jobDTO)={}: save query executed in {} ms", JobDTO jobDTO, (System.currentTimeMillis() - start));
	
	
	@Transactional
	public void updateJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering updateLocation(String jobId={},LocationDTO location={})", String jobId, LocationDTO location);
		log.debug(">>> Entering updateJob(JobDTO jobDTO={})", JobDTO jobDTO);
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		log.debug("updateLocation(String jobId={},LocationDTO location={}): optJob → {}", String jobId, LocationDTO location, optJob);
		long start = System.currentTimeMillis();
		
		log.debug("updateJob(JobDTO jobDTO={}): optJob → {}", JobDTO jobDTO, optJob);
		long start = System.currentTimeMillis();
		if (!optJob.isPresent())
			return;
		
		Job job = optJob.get();
		log.debug("updateLocation(String jobId={},LocationDTO location={}): job → {}", String jobId, LocationDTO location, job);
		job.setUpdatedOn((new Date()).toString());
		
		log.info("updateLocation(String jobId,LocationDTO location)={},{}: save query executed in {} ms", String jobId, LocationDTO location, (System.currentTimeMillis() - start));
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
		Optional<Job> optJob = dao.findById(jobId);
		
		log.debug("updateLocation(String jobId={},LocationDTO location={}): optJob → {}", String jobId, LocationDTO location, optJob);
		long start = System.currentTimeMillis();
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
