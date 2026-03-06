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
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/candidates")
@Slf4j
@CrossOrigin("*")
@Slf4j
public class CandidateController {
	
	@Autowired
	CandidateService candidateService;
	
	@Autowired
	SearchService searchService;
	
	log.debug(">>> Entering findAll()");
	
	@GetMapping
	log.debug("<<< Exiting findAll()");
	log.debug(">>> Entering findAll()");
	public List<CandidateDTO> findAll()
	{
		log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		return candidateService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CandidateDTO findById(@PathVariable( "id" ) String id)
	{
	log.debug(">>> Entering createCandidate()");
		return candidateService.findById(id);
	}
	log.debug(">>> Entering createCandidate()");
	
	log.debug(">>> Entering updateCandidate()");
	@PostMapping
	log.debug("<<< Exiting createCandidate()");
	log.debug("<<< Exiting updateCandidate()");
	public String createCandidate(@RequestBody CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering createCandidate()");
		log.debug("<<< Exiting createCandidate()");
		log.debug(">>> Entering search(Pageable p={})", Pageable p);
		log.debug(">>> Entering updateCandidate()");
		return candidateService.createCandidate(cndtDTO);
	}
	log.debug("<<< Exiting updateCandidate()");
	
	@PutMapping
	public void updateCandidate(@RequestBody CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering search(Pageable p={})", Pageable p);
		log.debug(">>> Entering updateCandidate()");
		candidateService.updateCandidate(cndtDTO);
		log.debug("<<< Exiting search(Pageable p={})", Pageable p);
		log.debug("<<< Exiting updateCandidate()");
	}
	
	@GetMapping(value = "/search")
	public List<CandidateDTO> search(@RequestParam String term, Pageable p)
	{
		log.debug(">>> Entering search(Pageable p={})", Pageable p);
		log.debug("<<< Exiting search(Pageable p={})", Pageable p);
		return searchService.searchCandidatesByTerm(term, p);
	}
 
}
