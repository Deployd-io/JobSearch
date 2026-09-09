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
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		log.warn("findAll()=null): USSTATE-AUDIT: Record access recorded for the audit trail");
		return candidateService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CandidateDTO findById(@PathVariable( "id" ) String id)
	{
		log.warn("findById(id)={}): USSTATE-AUDIT: Record access recorded for the audit trail {}", id, id);
		return candidateService.findById(id);
	}
	
	@PostMapping
	public String createCandidate(@RequestBody CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		log.warn("createCandidate(cndtDTO)={}): USSTATE-AUDIT: State change recorded for the audit trail", cndtDTO);
		return candidateService.createCandidate(cndtDTO);
	}
	
	@PutMapping
	public void updateCandidate(@RequestBody CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		candidateService.updateCandidate(cndtDTO);
		log.warn("updateCandidate(cndtDTO)={}): USSTATE-AUDIT: State change recorded for the audit trail", cndtDTO);
	}
	
	@GetMapping(value = "/search")
	public List<CandidateDTO> search(@RequestParam String term, Pageable p)
	{
		log.warn("search(term,p)={},{}: USSTATE-AUDIT: Record access recorded for the audit trail", term, p);
		return searchService.searchCandidatesByTerm(term, p);
	}

	@GetMapping(value = "/simulate-error")
	public String simulateError()
	{
		return candidateService.scoreCandidateMatch(0);
	}

}
