package com.jobportal.dto;

import java.util.List;

import com.jobportal.model.ProposalStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
public class ProposalDTO extends AuditableDTO {
	
	private String proposalId;
	private String jobId;
	
	private String coverLetter;
	
	private String bidPrice;
	private String estimatedTime;
	
	private String contactEmail;
	private String contactPhone;
	
	private double lat;
	private double lng;
	
	private ProposalStatus status;
	private List<MessageDTO> messages;

}
