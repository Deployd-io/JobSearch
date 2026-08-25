package com.jobportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor
@Slf4j
public class ReferenceDTO extends AuditableDTO {

	private String referenceId;
	
	private String name;
	private String company;
	private String email;
	private String phoneNumber;
	private String relation;
	
}

