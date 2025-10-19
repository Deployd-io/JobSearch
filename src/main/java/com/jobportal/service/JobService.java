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

@Slf4j
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
	
	
	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	public List<JobDTO> findAll()
	{
		log.debug("<<< Exiting findAll()");
		log.info("findAll(): find query executed in {} ms", (System.currentTimeMillis() - start));
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
			long start = System.currentTimeMillis();
			log.debug("findById(id={}): optJob → {}", id, optJob);
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	}
	
	public JobDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		log.debug("<<< Exiting findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(id);
		
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		long start = System.currentTimeMillis();
		log.debug("findById(id={}): optJob → {}", id, optJob);
		if (!optJob.isPresent())
			log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
			return null;
		
		log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		long start = System.currentTimeMillis();
		List jobs1 = dao.findByContactEmail(contactEmail);
		
		log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
			long start = System.currentTimeMillis();
			log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
			log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		
		// fill in the proposal details
		jobs.forEach(job -> {
			log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
			job.setProposals(proposalService.findByJobId(job.getJobId()));
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
		});
		log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		return jobs;
	}
	log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
	
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		Job job = modelMapper.map(jobDTO, Job.class);
		job.setCreatedOn((new Date()).toString());
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		job.setUpdatedOn(job.getCreatedOn());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		job.setPoint(point);
		
		log.debug("updateJob(jobDTO={}): point → {}", jobDTO, point);
		dao.save(job);
		log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		return job.getJobId();
	}
	
	
	log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
	long start = System.currentTimeMillis();
	@Transactional
	public void updateJob(JobDTO jobDTO)
	log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
	log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
	{
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		
		log.debug("updateLocation(jobId={},location={}): point → {}", jobId, location, point);
		log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		if (!optJob.isPresent())
			return;
			log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
			log.debug("<<< Exiting updateLocation(jobId={},location={})", jobId, location);
		
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
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobId);
		
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
