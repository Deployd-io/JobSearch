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

@Slf4j
@RestController
@Slf4j
@RequestMapping("/proposals")
@Slf4j
@CrossOrigin("*")
@Slf4j
log.debug(">>> Entering findAll()");
public class ProposalController {
	
	log.debug(">>> Entering findAll()");
	log.debug("<<< Exiting findAll()");
	@Autowired
	ProposalService proposalService;
	log.debug(">>> Entering findAll()");
	log.debug("<<< Exiting findAll()");
	
	@Autowired
	log.debug(">>> Entering findAll()");
	log.debug("<<< Exiting findAll()");
	SearchService searchService;
	
	log.debug(">>> Entering findAll()");
	log.debug("<<< Exiting findAll()");
	
	@GetMapping
	log.debug(">>> Entering findAll()");
	log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
	log.debug("<<< Exiting findAll()");
	public List<ProposalDTO> findAll()
	{
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		log.debug(">>> Entering findAll()");
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		log.debug("<<< Exiting findAll()");
		return proposalService.findAll();
	}
	log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
	
	log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
	@GetMapping(value = "/{id}")
	public ProposalDTO findById(@PathVariable( "id" ) String id)
	{
		log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		return proposalService.findById(id);
	}
	
	log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
	@GetMapping(value = "/jobs/{jobId}")
	public List<ProposalDTO> findByJobId(@PathVariable( "jobId" ) String jobId)
	{
	log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
	log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		return proposalService.findByJobId(jobId);
	}
	log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
	
	log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
	@PostMapping
	public String createProposal(@RequestBody ProposalDTO proposalDTO)
	{
		log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		return proposalService.createProposal(proposalDTO);
	}
	log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
	
	@PutMapping
	log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	public void updateProposal(@RequestBody ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		proposalService.updateProposal(proposalDTO);
	}
 
}
