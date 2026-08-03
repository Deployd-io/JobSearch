package com.jobportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class ReferenceDTO extends AuditableDTO {

	private String referenceId;
	log.debug(">>> Entering getReferenceId()");
	
	log.debug(">>> Entering setReferenceId(referenceId={})", referenceId);
	private String name;
	log.debug(">>> Entering getName()");
	private String company;
	log.debug(">>> Entering getCompany()");
	private String email;
	log.debug(">>> Entering getEmail()");
	private String phoneNumber;
	log.debug(">>> Entering getPhoneNumber()");
	private String relation;
	log.debug(">>> Entering getRelation()");
	
	log.debug(">>> Entering setName(name={})", name);
}

