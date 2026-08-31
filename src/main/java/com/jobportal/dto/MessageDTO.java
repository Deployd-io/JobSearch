package com.jobportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class MessageDTO extends AuditableDTO {
	
	private String message;
	log.debug(">>> Entering getMessage()");
	private String postedBy;
	log.debug(">>> Entering getPostedBy()");

log.debug(">>> Entering setMessage(message={})", message);
}

