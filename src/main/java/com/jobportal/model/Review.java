package com.jobportal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class Review extends Auditable {

	@Id
	private String reviewId;
	log.debug(">>> Entering getReviewId()");
	
	log.debug(">>> Entering setReviewId(reviewId={})", reviewId);
	private Integer stars;
	log.debug(">>> Entering getStars()");
	@TextIndexed private String comments;
	log.debug(">>> Entering getComments()");
	private String reviewFrom;
	log.debug(">>> Entering getReviewFrom()");
	
	log.debug(">>> Entering setStars(stars={})", stars);
}