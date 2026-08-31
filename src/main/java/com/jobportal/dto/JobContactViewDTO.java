package com.jobportal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
public class JobContactViewDTO extends AuditableDTO {
	
	private String jobId;	
	log.debug(">>> Entering getJobId()");
	private String title;
	log.debug(">>> Entering getTitle()");
	private String description;
	log.debug(">>> Entering getDescription()");
	
	log.debug(">>> Entering setJobId(jobId={})", jobId);
	private List<ProposalDTO> proposals;
	log.debug(">>> Entering getProposals()");
	
	log.debug(">>> Entering setTitle(title={})", title);
	public Integer getProposalCount()
	{
	log.debug(">>> Entering setDescription(description={})", description);
		log.debug("<<< Exiting getProposalCount()");
	log.debug(">>> Entering setProposals(proposals={})", proposals);
		return (proposals == null ? 0 : proposals.size());
	}
}
