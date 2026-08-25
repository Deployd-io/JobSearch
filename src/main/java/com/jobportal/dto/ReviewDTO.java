package com.jobportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class ReviewDTO extends AuditableDTO {

	private String reviewId;
	
	private Integer stars;
	private String comments;
	private String reviewFrom;
	
}
