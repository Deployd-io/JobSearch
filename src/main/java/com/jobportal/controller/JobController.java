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
		log.debug(">>> Entering findById(id={})", id);
		classLevel = "changing";
		log.debug("findById(id={}): classLevel → {}", id, classLevel);
		log.debug("<<< Exiting findById(id={})", id);
		return jobService.findById(id);
	}

	@GetMapping(value = "/contacts/{contactEmail}")
	public List<JobContactViewDTO> findByContactEmail(@PathVariable( "contactEmail" ) String contactEmail)
	{
		log.debug(">>> Entering findByContactEmail(contactEmail={})", contactEmail);
		log.debug("<<< Exiting findByContactEmail(contactEmail={})", contactEmail);
		return jobService.findByContactEmail(contactEmail);
	}

	@PostMapping
	public String createJob(@RequestBody JobDTO jobDTO)
	{
		log.debug(">>> Entering createJob(jobDTO={})", jobDTO);
		String result = "";
		try {
			log.debug("createJob(jobDTO={}): result → {}", jobDTO, result);
			result = jobService.createJob(jobDTO);
		} catch (Exception e) {
			e.printStackTrace();;
			log.error("Exception in createJob(jobDTO={}): {}", jobDTO, e.getMessage(), e);
		}
		log.debug("<<< Exiting createJob(jobDTO={})", jobDTO);
		return result;
	}

	@PutMapping
	public void updateJob(@RequestBody JobDTO jobDTO)
	{
		log.debug(">>> Entering updateJob(jobDTO={})", jobDTO);
		String testValue = "Testing my local changes";
		testValue = "value changed, needs logging";
		log.debug("updateJob(jobDTO={}): testValue → {}", jobDTO, testValue);

		jobService.updateJob(jobDTO);
	}

	@GetMapping(value = "/search")
	public List<JobDTO> search(@RequestParam String term, Pageable p)
	{
		return searchService.searchJobsByTerm(term, p);
	}

	@GetMapping(value = "/simulate-error")
	public String simulateError()
	{
		return jobService.parseJobBudget("12k-USD");
	}

	@GetMapping(value = "/simulate-search-error")
	public String simulateSearchError()
	{
		return searchService.applyDynamicFilter("not-a-number");
	}

}
