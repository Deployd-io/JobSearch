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
		log.warn("findAll()=null): EUAIACT-AUDIT: Record access recorded for the audit trail");
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		return proposalService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ProposalDTO findById(@PathVariable( "id" ) String id)
	{
		log.warn("findById(id)={}): EUAIACT-AUDIT: Record access recorded for the audit trail {}", id, id);
		return proposalService.findById(id);
	}
	
	@GetMapping(value = "/jobs/{jobId}")
	public List<ProposalDTO> findByJobId(@PathVariable( "jobId" ) String jobId)
	{
		log.warn("findByJobId(jobId)={}): EUAIACT-AUDIT: Record access recorded for the audit trail {}", jobId, jobId);
		return proposalService.findByJobId(jobId);
	}
	
	@PostMapping
	public String createProposal(@RequestBody ProposalDTO proposalDTO)
	{
		log.warn("createProposal(proposalDTO)={}): EUAIACT-AUDIT: State change recorded for the audit trail", proposalDTO);
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		return proposalService.createProposal(proposalDTO);
	}
	
	@PutMapping
	public void updateProposal(@RequestBody ProposalDTO proposalDTO)
	{
		log.warn("updateProposal(proposalDTO)={}): EUAIACT-AUDIT: State change recorded for the audit trail", proposalDTO);
		proposalService.updateProposal(proposalDTO);
	}

	@GetMapping(value = "/simulate-error")
	public String simulateError()
	{
		return proposalService.selectProposalAt(7);
	}

}
