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

import com.jobportal.dto.CandidateDTO;
import com.jobportal.service.CandidateService;
import com.jobportal.service.SearchService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/candidates")
@CrossOrigin("*")
@Slf4j
public class CandidateController {
	
	@Autowired
	CandidateService candidateService;
	
	@Autowired
	SearchService searchService;
	
	
	@GetMapping
	public List<CandidateDTO> findAll()
	{
		logger.log_integrity("ENTERING: findAll() method");
		return candidateService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CandidateDTO findById(@PathVariable( "id" ) String id)
	{
		logger.log_integrity("ENTERING: findById() method");
		return candidateService.findById(id);
	}
	
	@PostMapping
	public String createCandidate(@RequestBody CandidateDTO cndtDTO)
	{
		logger.log_integrity("ENTERING: createCandidate() method");
		return candidateService.createCandidate(cndtDTO);
	}
	
	@PutMapping
	public void updateCandidate(@RequestBody CandidateDTO cndtDTO)
	{
		logger.log_integrity("ENTERING: updateCandidate() method");
		candidateService.updateCandidate(cndtDTO);
	}
	
	@GetMapping(value = "/search")
	public List<CandidateDTO> search(@RequestParam String term, Pageable p)
	{
		logger.log_integrity("ENTERING: search() method");
		return searchService.searchCandidatesByTerm(term, p);
	}

	@GetMapping(value = "/simulate-error")
	public String simulateError()
	{
		logger.log_integrity("ENTERING: simulateError() method");
		return candidateService.scoreCandidateMatch(0);
	}

}
