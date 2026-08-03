package com.jobportal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
public class CandidateDTO extends AuditableDTO {
	
	private String candidateId;
	log.debug(">>> Entering getCandidateId()");
	
	log.debug(">>> Entering setCandidateId(candidateId={})", candidateId);
	private String name;
	log.debug(">>> Entering getName()");
	private String email;
	log.debug(">>> Entering getEmail()");
	private String skills;
	log.debug(">>> Entering getSkills()");
	private String desiredJobType;
	log.debug(">>> Entering getDesiredJobType()");

	log.debug(">>> Entering setName(name={})", name);
	private String resume;
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
	private double lat;
	log.debug(">>> Entering getLat()");
	private double lng;
	log.debug(">>> Entering getLng()");
	
	log.debug(">>> Entering setSkills(skills={})", skills);
	private List<ReviewDTO> reviews;
	log.debug(">>> Entering getReviews()");
	private List<ReferenceDTO> references;
	log.debug(">>> Entering getReferences()");
	private List<MessageDTO> messages;
	log.debug(">>> Entering getMessages()");
	
	log.debug(">>> Entering setDesiredJobType(desiredJobType={})", desiredJobType);
	public Integer getReviewCount()
	{
	log.debug(">>> Entering setResume(resume={})", resume);
		log.debug("<<< Exiting getReviewCount()");
	log.debug(">>> Entering setCoverLetter(coverLetter={})", coverLetter);
	log.debug(">>> Entering setLinkedInProfile(linkedInProfile={})", linkedInProfile);
		return (reviews == null ? 0 : reviews.size());
	}

	public Integer getMessageCount()
	{
	log.debug(">>> Entering setPersonalIntro(personalIntro={})", personalIntro);
		log.debug("<<< Exiting getMessageCount()");
	log.debug(">>> Entering setAdditionalInfo(additionalInfo={})", additionalInfo);
		return (messages == null ? 0 : messages.size());
	}
}
