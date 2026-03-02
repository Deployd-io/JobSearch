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

@Slf4j
@Service
@Slf4j
public class JobService {
	
	@Autowired
	JobDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	ModelMapperService modelMapperService;

	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	@Autowired
	ProposalService proposalService;
	log.debug(">>> Entering findById(id={})", id);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	log.debug("findById(id={}): optJob → {}", id, optJob);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	
	log.debug("<<< Exiting findAll()");
	
	log.debug(">>> Entering findById(id={})", id);
	log.debug("<<< Exiting findById(id={})", id);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	log.debug("findById(id={}): optJob → {}", id, optJob);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	public List<JobDTO> findAll()
	{
	log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findById(id={})", id);
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		log.debug("findById(id={}): optJob → {}", id, optJob);
		log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
			log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
			long start = System.currentTimeMillis();
	}
	log.debug(">>> Entering findById(id={})", id);
	log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
	long start = System.currentTimeMillis();
	log.debug("<<< Exiting findById(id={})", id);
	log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	
	log.debug("findById(id={}): optJob → {}", id, optJob);
	log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
	log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
	long start = System.currentTimeMillis();
	log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
	log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
	log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
	log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
	long start = System.currentTimeMillis();
	public JobDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		long start = System.currentTimeMillis();
		log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(id);
		
		log.debug("<<< Exiting findById(id={})", id);
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		if (!optJob.isPresent())
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
			return null;
			log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
	log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
	long start = System.currentTimeMillis();
	
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
	log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
	log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
	long start = System.currentTimeMillis();
		log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		List jobs1 = dao.findByContactEmail(contactEmail);
		
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
			log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
			log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
			log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
		
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		// fill in the proposal details
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		jobs.forEach(job -> {
			job.setProposals(proposalService.findByJobId(job.getJobId()));
		});
		
		return jobs;
	}
	log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
	long start = System.currentTimeMillis();
	log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
	log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
	log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
	log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		Job job = modelMapper.map(jobDTO, Job.class);
		job.setCreatedOn((new Date()).toString());
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		job.setUpdatedOn(job.getCreatedOn());
		
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		
		dao.save(job);
		
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
		long start = System.currentTimeMillis();
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		
		return job.getJobId();
	}
	log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
	long start = System.currentTimeMillis();
	
	
	@Transactional
	log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
	public void updateJob(JobDTO jobDTO)
	{
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		
		if (!optJob.isPresent())
			log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
			return;
		
		Job job = optJob.get();
		job.setUpdatedOn((new Date()).toString());
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(jobDTO, job);
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
		long start = System.currentTimeMillis();
		
		dao.save(job);
	}
	
	@Transactional
	public void updateLocation(String jobId, LocationDTO location)
	{
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		Optional<Job> optJob = dao.findById(jobId);
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		
		if (!optJob.isPresent())
			log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
			return;
		
		Job job = optJob.get();
		Point point = new Point(location.getLongitude(), location.getLatitude());
		
		job.setPoint(point);
		
		dao.save(job);
	}
}
