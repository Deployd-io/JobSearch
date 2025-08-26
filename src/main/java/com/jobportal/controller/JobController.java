package com.jobportal.controller;

import java.util.List;

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
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@Autowired
	SearchService searchService;
	
	
	@GetMapping
	public List<JobDTO> findAll()
	{
		return jobService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public JobDTO findById(@PathVariable( "id" ) String id)
	{
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
		return jobService.createJob(jobDTO);
	}
	
	@PutMapping
	public void updateJob(@RequestBody JobDTO jobDTO)
	{
		jobService.updateJob(jobDTO);
	}
	
	@GetMapping(value = "/search")
	public List<JobDTO> search(@RequestParam String term, Pageable p)
	{
		return searchService.searchJobsByTerm(term, p);
	}
 
}
