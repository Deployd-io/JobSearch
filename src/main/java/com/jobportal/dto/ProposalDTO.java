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
	log.debug(">>> Entering getProposalId()");
	private String jobId;
	log.debug(">>> Entering getJobId()");
	
	log.debug(">>> Entering setProposalId(proposalId={})", proposalId);
	private String coverLetter;
	log.debug(">>> Entering getCoverLetter()");
	
	log.debug(">>> Entering setJobId(jobId={})", jobId);
	private String bidPrice;
	log.debug(">>> Entering getBidPrice()");
	private String estimatedTime;
	log.debug(">>> Entering getEstimatedTime()");
	
	log.debug(">>> Entering setCoverLetter(coverLetter={})", coverLetter);
	private String contactEmail;
	log.debug(">>> Entering getContactEmail()");
	private String contactPhone;
	log.debug(">>> Entering getContactPhone()");
	
	log.debug(">>> Entering setBidPrice(bidPrice={})", bidPrice);
	private double lat;
	log.debug(">>> Entering getLat()");
	private double lng;
	log.debug(">>> Entering getLng()");
	
	log.debug(">>> Entering setEstimatedTime(estimatedTime={})", estimatedTime);
	private ProposalStatus status;
	log.debug(">>> Entering getStatus()");
	private List<MessageDTO> messages;
	log.debug(">>> Entering getMessages()");

log.debug(">>> Entering setContactEmail(contactEmail={})", contactEmail);
}
