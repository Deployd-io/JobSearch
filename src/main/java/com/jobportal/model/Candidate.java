package com.jobportal.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.TextIndexed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class Candidate extends Auditable {

	@Id
	private String candidateId;
	log.debug(">>> Entering getCandidateId()");
	
	log.debug(">>> Entering setCandidateId(candidateId={})", candidateId);
	private String name;
	log.debug(">>> Entering getName()");
	private String email;
	log.debug(">>> Entering getEmail()");
	@TextIndexed private String skills;
	log.debug(">>> Entering getSkills()");
	private String desiredJobType; // FT/PT
	log.debug(">>> Entering getDesiredJobType()");
	private Point point; // location
	log.debug(">>> Entering getPoint()");
	
	log.debug(">>> Entering setName(name={})", name);
	private String resume; // link to s3 location
	log.debug(">>> Entering getResume()");
	private String coverLetter;
	log.debug(">>> Entering getCoverLetter()");
	private String linkedInProfile;
	log.debug(">>> Entering getLinkedInProfile()");
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
	
	log.debug(">>> Entering setSkills(skills={})", skills);
}
