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

	log.debug(">>> Entering findAll()");
	@Autowired
	ProposalService proposalService;
	log.debug(">>> Entering findAll()");
	
	
	log.debug(">>> Entering findAll()");
	log.debug(">>> Entering findById(id={})", id);
	long start = System.currentTimeMillis();
	public List<JobDTO> findAll()
	{
		log.debug("<<< Exiting findAll()");
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		log.debug("findById(id={}): optJob → {}", id, optJob);
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findById(id={})", id);
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		long start = System.currentTimeMillis();
		log.debug("findById(id={}): optJob → {}", id, optJob);
			log.debug(">>> Entering findById(id={})", id);
			long start = System.currentTimeMillis();
			log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
			log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
			log.debug("<<< Exiting findById(id={})", id);
	}
	
	public JobDTO findById(String id)
	{
	log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
	log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
	log.debug("findById(id={}): optJob → {}", id, optJob);
		log.debug(">>> Entering findById(id={})", id);
		log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		log.debug("<<< Exiting findById(id={})", id);
		Optional<Job> optJob = dao.findById(id);
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		long start = System.currentTimeMillis();
		
		if (!optJob.isPresent())
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
			log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
			log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
			log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
			log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
			long start = System.currentTimeMillis();
			log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
			log.debug("findById(id={}): optJob → {}", id, optJob);
			return null;
		
		log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
		log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optJob.get(), JobDTO.class);
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
	}
	
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
	log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
	log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
	log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
	log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
	log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
	log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		log.debug("updateJob(jobDTO={}): point → {}", jobDTO, point);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		List jobs1 = dao.findByContactEmail(contactEmail);
		
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
			log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
			log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
			long start = System.currentTimeMillis();
			log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
		log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		long start = System.currentTimeMillis();
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		long start = System.currentTimeMillis();
		// fill in the proposal details
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		log.debug("updateLocation(jobId={},location={}): point → {}", jobId, location, point);
		log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		jobs.forEach(job -> {
			job.setProposals(proposalService.findByJobId(job.getJobId()));
			log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
			log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
			log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
			log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		});
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		log.debug("updateJob(jobDTO={}): point → {}", jobDTO, point);
		
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		return jobs;
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
	}
	
	log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		Job job = modelMapper.map(jobDTO, Job.class);
		job.setCreatedOn((new Date()).toString());
		log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
		log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		long start = System.currentTimeMillis();
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		job.setUpdatedOn(job.getCreatedOn());
		log.debug("updateLocation(jobId={},location={}): point → {}", jobId, location, point);
		log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
		log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
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
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
		log.debug("<<< Exiting updateLocation(jobId={},location={})", jobId, location);
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
