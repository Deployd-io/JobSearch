package com.jobportal.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class EmployerDTO extends AuditableDTO {

	private String employerId;
	log.debug(">>> Entering getEmployerId()");
	
	log.debug(">>> Entering setEmployerId(employerId={})", employerId);
	private String name;
	log.debug(">>> Entering getName()");
	private String email;
	log.debug(">>> Entering getEmail()");
	private String companyName;
	log.debug(">>> Entering getCompanyName()");
	
	log.debug(">>> Entering setName(name={})", name);
	private String personalIntro; // link to s3 location of audio/ video
	log.debug(">>> Entering getPersonalIntro()");
	private String additionalInfo;
	log.debug(">>> Entering getAdditionalInfo()");

	log.debug(">>> Entering setEmail(email={})", email);
	private double lat;
	log.debug(">>> Entering getLat()");
	private double lng;
	log.debug(">>> Entering getLng()");
	
	log.debug(">>> Entering setCompanyName(companyName={})", companyName);
	private List<ReviewDTO> reviews;
	log.debug(">>> Entering getReviews()");
	private List<ReferenceDTO> references;
	log.debug(">>> Entering getReferences()");
	private List<MessageDTO> messages;
	log.debug(">>> Entering getMessages()");
}
