package com.jobportal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
public class CandidateDTO extends AuditableDTO {
	
	private String candidateId;
	
	private String name;
	private String email;
	private String skills;
	private String desiredJobType;

	private String resume;
	private String coverLetter;
	private String linkedInProfile;
	private String personalIntro; // link to s3 location of audio/ video
	private String additionalInfo;
	
	private double lat;
	private double lng;
	
	private List<ReviewDTO> reviews;
	private List<ReferenceDTO> references;
	private List<MessageDTO> messages;
	
	public Integer getReviewCount()
	{
		log.debug(">>> Entering getReviewCount()");
		log.debug("<<< Exiting getReviewCount()");
		return (reviews == null ? 0 : reviews.size());
	}

	public Integer getMessageCount()
	{
		log.debug(">>> Entering getMessageCount()");
		log.debug("<<< Exiting getMessageCount()");
		return (messages == null ? 0 : messages.size());
	}
}
