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

@RestController
@RequestMapping("/proposals")
@Slf4j
@CrossOrigin("*")
@Slf4j
public class ProposalController {
	
	@Autowired
	ProposalService proposalService;
	
	@Autowired
	SearchService searchService;
	
	
	@GetMapping
	log.debug(">>> Entering findAll()");
	public List<ProposalDTO> findAll()
	log.debug("<<< Exiting findAll()");
	{
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		return proposalService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ProposalDTO findById(@PathVariable( "id" ) String id)
	{
		return proposalService.findById(id);
	}
	
	@GetMapping(value = "/jobs/{jobId}")
	public List<ProposalDTO> findByJobId(@PathVariable( "jobId" ) String jobId)
	{
		return proposalService.findByJobId(jobId);
	}
	log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
	
	log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
	@PostMapping
	public String createProposal(@RequestBody ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		return proposalService.createProposal(proposalDTO);
	}
	
	@PutMapping
	public void updateProposal(@RequestBody ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		proposalService.updateProposal(proposalDTO);
		log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	}
 
}
