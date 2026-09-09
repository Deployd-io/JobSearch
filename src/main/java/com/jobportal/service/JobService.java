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
		log.debug("<<< Exiting findAll()");
		log.warn("findAll()=null): USSTATE-AUDIT: Record access recorded for the audit trail");
		return dao.findAll().stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}
	
	public JobDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(id);
		
		if (!optJob.isPresent()) {
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
			log.debug("findById(id={}): optJob → {}", id, optJob);
			return null;
		}

		log.debug("<<< Exiting findById(id={})", id);
		log.warn("findById(id)={}): USSTATE-AUDIT: Record access recorded for the audit trail {}", id, id);
		return modelMapper.map(optJob.get(), JobDTO.class);
	}
	
	public List<JobContactViewDTO> findByContactEmail(String contactEmail)
	{
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		long start = System.currentTimeMillis();
		List jobs1 = dao.findByContactEmail(contactEmail);
		
		List<JobContactViewDTO> jobs = dao.findByContactEmail(contactEmail).stream().map(job -> 
			modelMapper.map(job, JobContactViewDTO.class)).collect(Collectors.toList());
			log.info("findByContactEmail(contactEmail)={}: find query executed in {} ms", contactEmail, (System.currentTimeMillis() - start));
			log.debug("findByContactEmail(contactEmail={}): jobs1 → {}", contactEmail, jobs1);
		
		// fill in the proposal details
		jobs.forEach(job -> {
			job.setProposals(proposalService.findByJobId(job.getJobId()));
			log.debug("findByContactEmail(contactEmail={}): job → {}", contactEmail, job);
		});
		
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		log.warn("findByContactEmail(contactEmail)={}): USSTATE-AUDIT: Record access recorded for the audit trail", contactEmail);
		return jobs;
	}
	
	@Transactional
	public String createJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		Job job = modelMapper.map(jobDTO, Job.class);
		job.setCreatedOn((new Date()).toString());
		log.debug("createJob(jobDTO={}): job → {}", jobDTO, job);
		long start = System.currentTimeMillis();
		job.setUpdatedOn(job.getCreatedOn());
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		log.debug("createJob(jobDTO={}): point → {}", jobDTO, point);
		log.info("createJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		job.setPoint(point);
		
		dao.save(job);
		
		//locationService.findByAddress(job.getJobId(), jobDTO.getCompleteAddress());
		
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		log.warn("createJob(jobDTO)={}): USSTATE-AUDIT: State change recorded for the audit trail", jobDTO);
		return job.getJobId();
	}
	
	
	@Transactional
	public void updateJob(JobDTO jobDTO)
	{
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobDTO.getJobId());
		
		if (!optJob.isPresent()) {
			log.debug("updateJob(jobDTO={}): optJob → {}", jobDTO, optJob);
			log.info("updateJob(jobDTO)={}: find query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
			return;
		}

		Job job = optJob.get();
		job.setUpdatedOn((new Date()).toString());
		log.debug("updateJob(jobDTO={}): job → {}", jobDTO, job);
		
		Point point = new Point(jobDTO.getLng(), jobDTO.getLat());
		job.setPoint(point);
		log.debug("updateJob(jobDTO={}): point → {}", jobDTO, point);
		
		modelMapperService.getNonNullModelMapper().map(jobDTO, job);
		
		dao.save(job);
		log.info("updateJob(jobDTO)={}: save query executed in {} ms", jobDTO, (System.currentTimeMillis() - start));
		log.warn("updateJob(jobDTO)={}): USSTATE-AUDIT: State change recorded for the audit trail", jobDTO);
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
	}
	
	@Transactional
	public void updateLocation(String jobId, LocationDTO location)
	{
		log.debug(">>> Entering updateLocation(jobId={},location={})", jobId, location);
		long start = System.currentTimeMillis();
		Optional<Job> optJob = dao.findById(jobId);
		
		if (!optJob.isPresent()) {
			log.debug("updateLocation(jobId={},location={}): optJob → {}", jobId, location, optJob);
			log.info("updateLocation(jobId,location)={},{}: find query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
			return;
		}

		Job job = optJob.get();
		Point point = new Point(location.getLongitude(), location.getLatitude());
		log.debug("updateLocation(jobId={},location={}): job → {}", jobId, location, job);
		
		job.setPoint(point);
		
		dao.save(job);
		log.info("updateLocation(jobId,location)={},{}: save query executed in {} ms", jobId, location, (System.currentTimeMillis() - start));
		log.warn("updateLocation(jobId,location)={},{}: USSTATE-AUDIT: State change recorded for the audit trail {}", jobId, location, jobId);
	}

	// --- Error simulation: NumberFormatException ---
	public String parseJobBudget(String rawBudget)
	{
		log.warn("parseJobBudget(rawBudget)={}): USSTATE-AUDIT: Record access recorded for the audit trail", rawBudget);
		try {
			int budget = Integer.parseInt(rawBudget);
			return "budget=" + budget;
		} catch (Exception e) {
			log.error("parseJobBudget(rawBudget={}): failed to parse job budget amount - {}", rawBudget, e.getMessage(), e);
			return "parseJobBudget failed: " + e.getMessage();
		}
	}
}
