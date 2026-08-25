package com.jobportal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
public class AuditableDTO {

	private String createdOn;
	private String updatedOn;

}
