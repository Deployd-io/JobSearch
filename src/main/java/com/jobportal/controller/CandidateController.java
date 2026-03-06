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
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
log.debug(">>> Entering findAll()");

@Slf4j
log.debug("<<< Exiting findAll()");
log.debug(">>> Entering findAll()");
@RestController
@Slf4j
log.debug("<<< Exiting findAll()");
log.debug(">>> Entering findAll()");
@RequestMapping("/candidates")
@Slf4j
log.debug("<<< Exiting findAll()");
log.debug(">>> Entering findAll()");
@CrossOrigin("*")
@Slf4j
log.debug(">>> Entering createCandidate()");
log.debug("<<< Exiting findAll()");
log.debug("<<< Exiting createCandidate()");
log.debug(">>> Entering findAll()");
public class CandidateController {
	log.debug(">>> Entering createCandidate()");
	
	log.debug(">>> Entering updateCandidate()");
	log.debug("<<< Exiting findAll()");
	log.debug("<<< Exiting createCandidate()");
	log.debug("<<< Exiting updateCandidate()");
	log.debug(">>> Entering findAll()");
	@Autowired
	log.debug(">>> Entering createCandidate()");
	CandidateService candidateService;
	log.debug(">>> Entering search(Pageable p={})", Pageable p);
	log.debug(">>> Entering updateCandidate()");
	log.debug("<<< Exiting findAll()");
	log.debug("<<< Exiting search(Pageable p={})", Pageable p);
	log.debug("<<< Exiting createCandidate()");
	log.debug("<<< Exiting updateCandidate()");
	log.debug(">>> Entering findAll()");
	
	log.debug(">>> Entering createCandidate()");
	@Autowired
	log.debug(">>> Entering search(Pageable p={})", Pageable p);
	log.debug(">>> Entering updateCandidate()");
	log.debug("<<< Exiting findAll()");
	log.debug("<<< Exiting search(Pageable p={})", Pageable p);
	log.debug("<<< Exiting createCandidate()");
	log.debug("<<< Exiting updateCandidate()");
	log.debug(">>> Entering findAll()");
	SearchService searchService;
	log.debug(">>> Entering createCandidate()");
	
	log.debug(">>> Entering search(Pageable p={})", Pageable p);
	log.debug(">>> Entering updateCandidate()");
	log.debug("<<< Exiting findAll()");
	log.debug("<<< Exiting search(Pageable p={})", Pageable p);
	log.debug("<<< Exiting createCandidate()");
	log.debug("<<< Exiting updateCandidate()");
	log.debug(">>> Entering findAll()");
	
	log.debug(">>> Entering createCandidate()");
	@GetMapping
	log.debug(">>> Entering search(Pageable p={})", Pageable p);
	log.debug(">>> Entering updateCandidate()");
	log.debug("<<< Exiting findAll()");
	log.debug("<<< Exiting search(Pageable p={})", Pageable p);
	log.debug("<<< Exiting createCandidate()");
	log.debug("<<< Exiting updateCandidate()");
	log.debug(">>> Entering findAll()");
	public List<CandidateDTO> findAll()
	{
	log.debug(">>> Entering createCandidate()");
		log.debug(">>> Entering search(Pageable p={})", Pageable p);
		log.debug(">>> Entering updateCandidate()");
		log.debug("<<< Exiting findAll()");
		log.debug("<<< Exiting search(Pageable p={})", Pageable p);
		log.debug("<<< Exiting createCandidate()");
		log.debug("<<< Exiting updateCandidate()");
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering createCandidate()");
		return candidateService.findAll();
	}
	log.debug("<<< Exiting createCandidate()");
	log.debug("<<< Exiting search(Pageable p={})", Pageable p);
	log.debug("<<< Exiting updateCandidate()");
	
	@GetMapping(value = "/{id}")
	public CandidateDTO findById(@PathVariable( "id" ) String id)
	{
	log.debug(">>> Entering search(Pageable p={})", Pageable p);
	log.debug(">>> Entering updateCandidate()");
	log.debug(">>> Entering createCandidate()");
		log.debug("<<< Exiting search(Pageable p={})", Pageable p);
		return candidateService.findById(id);
	}
	log.debug(">>> Entering createCandidate()");
	
	log.debug(">>> Entering updateCandidate()");
	log.debug(">>> Entering search(Pageable p={})", Pageable p);
	@PostMapping
	log.debug("<<< Exiting createCandidate()");
	log.debug("<<< Exiting search(Pageable p={})", Pageable p);
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
