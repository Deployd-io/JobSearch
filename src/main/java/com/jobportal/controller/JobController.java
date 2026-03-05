package com.jobportal.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.JobContactViewDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.service.JobService;
import com.jobportal.service.SearchService;

@RestController
@RequestMapping("/jobs")
@CrossOrigin("*")
@Slf4j
public class JobController {

	@Autowired
	JobService jobService;

	@Autowired
	SearchService searchService;

	private String classLevel = "Set at class level";


	@GetMapping
	public List<JobDTO> findAll()
	{
		log.debug("Entering method findAll");
		log.debug("<<< Exiting findAll()");
		return jobService.findAll();
	}

	@GetMapping(value = "/{id}")
	public JobDTO findById(@PathVariable( "id" ) String id)
	{
		classLevel = "changing";
		return jobService.findById(id);
	}

	@GetMapping(value = "/contacts/{contactEmail}")
	public List<JobContactViewDTO> findByContactEmail(@PathVariable( "contactEmail" ) String contactEmail)
	{
		return jobService.findByContactEmail(contactEmail);
	}

	@PostMapping
	public String createJob(@RequestBody JobDTO jobDTO)
	{
	log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
	log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
	log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
	log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
	log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		log.error("Exception in createJob(jobDTO={}): {}", jobDTO, e.getMessage(), e);
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		log.error("Exception in createJob(jobDTO={}): {}", jobDTO, e.getMessage(), e);
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		log.error("Exception in createJob(jobDTO={}): {}", jobDTO, e.getMessage(), e);
		log.debug("createJob(jobDTO={}): result → {}", jobDTO, result);
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		log.error("Exception in createJob(jobDTO={}): {}", jobDTO, e.getMessage(), e);
		log.debug("updateJob(jobDTO={}): testValue → {}", jobDTO, testValue);
		String result = "";
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
		log.error("Exception in createJob(jobDTO={}): {}", jobDTO, e.getMessage(), e);
		log.debug("updateJob(jobDTO={}): testValue → {}", jobDTO, testValue);
		try {
			log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
			log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
			log.debug(">>> Entering search(term={},p={})", term, p);
			log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
			result = jobService.createJob(jobDTO);
			log.debug("updateJob(jobDTO={}): testValue → {}", jobDTO, testValue);
			log.debug("<<< Exiting search(term={},p={})", term, p);
		} catch (Exception e) {
			log.error("Exception in createJob(jobDTO={}): {}", jobDTO, e.getMessage(), e);
			log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
			log.debug(">>> Entering search(term={},p={})", term, p);
			log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
			e.printStackTrace();;
			log.debug("updateJob(jobDTO={}): testValue → {}", jobDTO, testValue);
			log.debug("<<< Exiting search(term={},p={})", term, p);
			log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		}
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		log.debug(">>> Entering search(term={},p={})", term, p);
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
		return result;
	}
	log.debug("<<< Exiting search(term={},p={})", term, p);

	@PutMapping
	log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);
	log.debug(">>> Entering search(term={},p={})", term, p);
	public void updateJob(@RequestBody JobDTO jobDTO)
	{
	log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		log.debug("<<< Exiting search(term={},p={})", term, p);
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		String testValue = "Testing my local changes";
		log.debug(">>> Entering search(term={},p={})", term, p);
		testValue = "value changed, needs logging";
		log.debug("<<< Exiting updateJob(jobDTO={})", jobDTO);

		log.debug("<<< Exiting search(term={},p={})", term, p);
		jobService.updateJob(jobDTO);
	}

	@GetMapping(value = "/search")
	public List<JobDTO> search(@RequestParam String term, Pageable p)
	{
	log.debug(">>> Entering search(term={},p={})", term, p);
		log.debug(">>> Entering search(term={},p={})", term, p);
		log.debug("<<< Exiting search(term={},p={})", term, p);
		return searchService.searchJobsByTerm(term, p);
	}

}
