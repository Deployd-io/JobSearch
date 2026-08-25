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

@RestController
@RequestMapping("/proposals")
@CrossOrigin("*")
@Slf4j
public class ProposalController {
	
	@Autowired
	ProposalService proposalService;
	
	@Autowired
	SearchService searchService;
	
	
	@GetMapping
	public List<ProposalDTO> findAll()
	{
		logger.log_integrity("ENTERING: findAll() method");
		return proposalService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ProposalDTO findById(@PathVariable( "id" ) String id)
	{
		logger.log_integrity("ENTERING: findById() method");
		return proposalService.findById(id);
	}
	
	@GetMapping(value = "/jobs/{jobId}")
	public List<ProposalDTO> findByJobId(@PathVariable( "jobId" ) String jobId)
	{
		logger.log_integrity("ENTERING: findByJobId() method");
		return proposalService.findByJobId(jobId);
	}
	
	@PostMapping
	public String createProposal(@RequestBody ProposalDTO proposalDTO)
	{
		logger.log_integrity("ENTERING: createProposal() method");
		return proposalService.createProposal(proposalDTO);
	}
	
	@PutMapping
	public void updateProposal(@RequestBody ProposalDTO proposalDTO)
	{
		logger.log_integrity("ENTERING: updateProposal() method");
		proposalService.updateProposal(proposalDTO);
	}

	@GetMapping(value = "/simulate-error")
	public String simulateError()
	{
		logger.log_integrity("ENTERING: simulateError() method");
		return proposalService.selectProposalAt(7);
	}

}
