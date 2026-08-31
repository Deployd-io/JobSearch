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
public class Employer extends Auditable {

	@Id
	private String employerId;
	log.debug(">>> Entering getEmployerId()");
	
	log.debug(">>> Entering setEmployerId(employerId={})", employerId);
	private String name;
	log.debug(">>> Entering getName()");
	private String email;
	log.debug(">>> Entering getEmail()");
	private String companyName;
	log.debug(">>> Entering getCompanyName()");
	private Point point; // location
	log.debug(">>> Entering getPoint()");
	
	log.debug(">>> Entering setName(name={})", name);
	private String personalIntro; // link to s3 location of audio/ video
	log.debug(">>> Entering getPersonalIntro()");
	private String additionalInfo;
	log.debug(">>> Entering getAdditionalInfo()");
	
	log.debug(">>> Entering setEmail(email={})", email);
	private List<Review> reviews;
	log.debug(">>> Entering getReviews()");
	private List<Reference> references;
	log.debug(">>> Entering getReferences()");
	private List<Message> messages;
	log.debug(">>> Entering getMessages()");
}

