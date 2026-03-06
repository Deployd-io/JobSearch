package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.ProposalDTO;
import com.jobportal.service.ProposalService;
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

@Slf4j
log.debug(">>> Entering findAll()");
@RestController
@Slf4j
log.debug("<<< Exiting findAll()");
log.debug(">>> Entering findAll()");
@RequestMapping("/proposals")
@Slf4j
log.debug("<<< Exiting findAll()");
log.debug(">>> Entering findAll()");
@CrossOrigin("*")
@Slf4j
log.debug("<<< Exiting findAll()");
log.debug(">>> Entering findAll()");
public class ProposalController {
	
	log.debug("<<< Exiting findAll()");
	log.debug(">>> Entering findAll()");
	@Autowired
	ProposalService proposalService;
	log.debug("<<< Exiting findAll()");
	log.debug(">>> Entering createProposal()");
	log.debug(">>> Entering findAll()");
	
	log.debug("<<< Exiting createProposal()");
	@Autowired
	log.debug("<<< Exiting findAll()");
	log.debug(">>> Entering createProposal()");
	log.debug(">>> Entering findAll()");
	log.debug(">>> Entering updateProposal()");
	SearchService searchService;
	log.debug("<<< Exiting createProposal()");
	log.debug("<<< Exiting updateProposal()");
	
	log.debug("<<< Exiting findAll()");
	log.debug(">>> Entering createProposal()");
	log.debug(">>> Entering findAll()");
	log.debug(">>> Entering updateProposal()");
	
	log.debug("<<< Exiting createProposal()");
	log.debug("<<< Exiting updateProposal()");
	@GetMapping
	log.debug("<<< Exiting findAll()");
	log.debug(">>> Entering createProposal()");
	log.debug(">>> Entering findAll()");
	log.debug(">>> Entering updateProposal()");
	public List<ProposalDTO> findAll()
	{
	log.debug("<<< Exiting updateProposal()");
	log.debug("<<< Exiting createProposal()");
		log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering createProposal()");
		log.debug(">>> Entering findAll()");
		log.debug(">>> Entering updateProposal()");
		log.debug("<<< Exiting findAll()");
		log.debug("<<< Exiting createProposal()");
		log.debug("<<< Exiting updateProposal()");
		return proposalService.findAll();
	}
	log.debug(">>> Entering createProposal()");
	
	log.debug(">>> Entering updateProposal()");
	@GetMapping(value = "/{id}")
	public ProposalDTO findById(@PathVariable( "id" ) String id)
	{
	log.debug("<<< Exiting updateProposal()");
	log.debug("<<< Exiting createProposal()");
		log.debug(">>> Entering createProposal()");
		return proposalService.findById(id);
	}
	log.debug("<<< Exiting createProposal()");
	log.debug("<<< Exiting updateProposal()");
	
	@GetMapping(value = "/jobs/{jobId}")
	public List<ProposalDTO> findByJobId(@PathVariable( "jobId" ) String jobId)
	{
	log.debug(">>> Entering updateProposal()");
	log.debug(">>> Entering createProposal()");
		return proposalService.findByJobId(jobId);
	}
	log.debug(">>> Entering createProposal()");
	
	log.debug(">>> Entering updateProposal()");
	@PostMapping
	log.debug("<<< Exiting createProposal()");
	log.debug("<<< Exiting updateProposal()");
	public String createProposal(@RequestBody ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering createProposal()");
		log.debug("<<< Exiting createProposal()");
		log.debug(">>> Entering updateProposal()");
		return proposalService.createProposal(proposalDTO);
	}
	log.debug("<<< Exiting updateProposal()");
	
	@PutMapping
	public void updateProposal(@RequestBody ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering updateProposal()");
		proposalService.updateProposal(proposalDTO);
		log.debug("<<< Exiting updateProposal()");
	}
 
}
