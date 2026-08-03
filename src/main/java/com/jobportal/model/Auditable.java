package com.jobportal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class Auditable {
	
	private String createdOn;
	log.debug(">>> Entering getCreatedOn()");
	private String updatedOn;
	log.debug(">>> Entering getUpdatedOn()");

log.debug(">>> Entering setCreatedOn(createdOn={})", createdOn);
}
