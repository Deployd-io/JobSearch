package com.jobportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class ReviewDTO extends AuditableDTO {

	private String reviewId;
	log.debug(">>> Entering getReviewId()");
	
	log.debug(">>> Entering setReviewId(reviewId={})", reviewId);
	private Integer stars;
	log.debug(">>> Entering getStars()");
	private String comments;
	log.debug(">>> Entering getComments()");
	private String reviewFrom;
	log.debug(">>> Entering getReviewFrom()");
	
	log.debug(">>> Entering setStars(stars={})", stars);
}
