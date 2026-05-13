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
	ProposalService proposalService;
	
	
	log.debug(">>> Entering findAll()");
	public List<JobDTO> findAll()
	{
		log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
			log.debug(">>> Entering findById(id={})", id);
			long start = System.currentTimeMillis();
	}
	
	public JobDTO findById(String id)
	{
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.debug("findById(id={}): optJob → {}", id, optJob);
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findById(id={})", id);
		Optional<Job> optJob = dao.findById(id);
		
		if (!optJob.isPresent())
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
			log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
			long start = System.currentTimeMillis();
			log.debug("findById(id={}): optJob → {}", id, optJob);
			return null;
		
		log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
	log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		List jobs1 = dao.findByContactEmail(contactEmail);
		
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
			log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
			log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		long start = System.currentTimeMillis();
		// fill in the proposal details
		jobs.forEach(job -> {
			job.setProposals(proposalService.findByJobId(job.getJobId()));
			log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
			log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
			log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		});
		
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		return jobs;
	}
	
	log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		Job job = modelMapper.map(jobDTO, Job.class);
		job.setCreatedOn((new Date()).toString());
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		long start = System.currentTimeMillis();
		job.setUpdatedOn(job.getCreatedOn());
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		job.setPoint(point);
		
		dao.save(job);
		log.debug("updateJob(jobDTO={}): point → {}", jobDTO, point);
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		return job.getJobId();
	}
	
	
	@Transactional
	log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
	long start = System.currentTimeMillis();
	public void updateJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
		log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		
		if (!optJob.isPresent())
			log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
			log.debug("updateLocation(jobId={},location={}): point → {}", jobId, location, point);
			log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
			log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
			return;
		
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		Job job = optJob.get();
		job.setUpdatedOn((new Date()).toString());
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		log.debug("updateJob(jobDTO={}): point → {}", jobDTO, point);
		
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
		
		if (!optJob.isPresent())
			log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
			log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
			return;
		
		Job job = optJob.get();
		Point point = new Point(location.getLongitude(), location.getLatitude());
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		log.debug("updateLocation(jobId={},location={}): point → {}", jobId, location, point);
		
		job.setPoint(point);
		
		dao.save(job);
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateLocation(jobId={},location={})", jobId, location);
	}
}
