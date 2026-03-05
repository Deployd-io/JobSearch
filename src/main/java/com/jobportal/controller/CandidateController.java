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
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Slf4j
@RestController
@Slf4j
@RequestMapping("/candidates")
@Slf4j
@CrossOrigin("*")
@Slf4j
public class CandidateController {
	
	log.debug(">>> Entering findAll()");
	@Autowired
	CandidateService candidateService;
	log.debug(">>> Entering findAll()");
	log.debug("<<< Exiting findAll()");
	
	@Autowired
	log.debug(">>> Entering findAll()");
	log.debug("<<< Exiting findAll()");
	SearchService searchService;
	
	log.debug(">>> Entering findAll()");
	log.debug("<<< Exiting findAll()");
	
	log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
	@GetMapping
	log.debug(">>> Entering findAll()");
	log.debug("<<< Exiting findAll()");
	log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
	public List<CandidateDTO> findAll()
	{
	log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		log.debug("<<< Exiting updateCandidate(cndtDTO={})", cndtDTO);
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		return candidateService.findAll();
	}
	
	log.debug(">>> Entering search(term={},p={})", term, p);
	log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
	@GetMapping(value = "/{id}")
	public CandidateDTO findById(@PathVariable( "id" ) String id)
	{
	log.debug("<<< Exiting search(term={},p={})", term, p);
	log.debug("<<< Exiting updateCandidate(cndtDTO={})", cndtDTO);
	log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
	log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		log.debug(">>> Entering search(term={},p={})", term, p);
		return candidateService.findById(id);
	}
	log.debug("<<< Exiting updateCandidate(cndtDTO={})", cndtDTO);
	log.debug("<<< Exiting search(term={},p={})", term, p);
	log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
	
	log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
	@PostMapping
	log.debug(">>> Entering search(term={},p={})", term, p);
	public String createCandidate(@RequestBody CandidateDTO cndtDTO)
	{
		log.debug("<<< Exiting updateCandidate(cndtDTO={})", cndtDTO);
		log.debug("<<< Exiting search(term={},p={})", term, p);
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		return candidateService.createCandidate(cndtDTO);
	}
	log.debug(">>> Entering search(term={},p={})", term, p);
	log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
	
	@PutMapping
	log.debug("<<< Exiting updateCandidate(cndtDTO={})", cndtDTO);
	public void updateCandidate(@RequestBody CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		candidateService.updateCandidate(cndtDTO);
		log.debug(">>> Entering search(term={},p={})", term, p);
	}
	
	@GetMapping(value = "/search")
	public List<CandidateDTO> search(@RequestParam String term, Pageable p)
	{
	log.debug("<<< Exiting search(term={},p={})", term, p);
		log.debug(">>> Entering search(term={},p={})", term, p);
		return searchService.searchCandidatesByTerm(term, p);
	}
 
}
