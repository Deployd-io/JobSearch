package com.jobportal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
public class JobContactViewDTO extends AuditableDTO {
	
	private String jobId;	
	private String title;
	private String description;
	
	private List<ProposalDTO> proposals;
	
	public Integer getProposalCount()
	{
		log.info("ENTERING: getProposalCount() method");
		return (proposals == null ? 0 : proposals.size());
	}
}
