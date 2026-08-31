package com.jobportal.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class Proposal extends Auditable {

	@Id
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
	private Point point;
	log.debug(">>> Entering getPoint()");
	
	log.debug(">>> Entering setBidPrice(bidPrice={})", bidPrice);
	private ProposalStatus status;
	log.debug(">>> Entering getStatus()");
	private List<Message> messages;
	log.debug(">>> Entering getMessages()");
}
