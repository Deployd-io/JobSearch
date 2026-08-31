package com.jobportal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Document
@Getter @Setter @NoArgsConstructor
@Slf4j
public class Job extends Auditable {
	
	@Id
	private String jobId;
	log.debug(">>> Entering getJobId()");
	
	log.debug(">>> Entering setJobId(jobId={})", jobId);
	@TextIndexed private String title;
	log.debug(">>> Entering getTitle()");
	@TextIndexed private String description;
	log.debug(">>> Entering getDescription()");
	
	log.debug(">>> Entering setTitle(title={})", title);
	private String startDate;
	log.debug(">>> Entering getStartDate()");
	private String companyName;
	log.debug(">>> Entering getCompanyName()");
	private String additionalInfo;
	log.debug(">>> Entering getAdditionalInfo()");
	
	log.debug(">>> Entering setDescription(description={})", description);
	private String categoryId;
	log.debug(">>> Entering getCategoryId()");
	
	log.debug(">>> Entering setStartDate(startDate={})", startDate);
	@TextIndexed private String city;
	log.debug(">>> Entering getCity()");
	private String state;
	log.debug(">>> Entering getState()");
	private Integer zipCode;
	log.debug(">>> Entering getZipCode()");
	private String country;
	log.debug(">>> Entering getCountry()");
	private Point point;
	log.debug(">>> Entering getPoint()");
	
	log.debug(">>> Entering setCompanyName(companyName={})", companyName);
	private String skills;
	log.debug(">>> Entering getSkills()");
	private String yearsOfExpNeeded;
	log.debug(">>> Entering getYearsOfExpNeeded()");
	private String salaryType;
	log.debug(">>> Entering getSalaryType()");
	private String salary;
	log.debug(">>> Entering getSalary()");
	private String salaryCurrency;
	log.debug(">>> Entering getSalaryCurrency()");
	
	log.debug(">>> Entering setAdditionalInfo(additionalInfo={})", additionalInfo);
	private String contactEmail;
	log.debug(">>> Entering getContactEmail()");
	private String contactPhone;
	log.debug(">>> Entering getContactPhone()");

log.debug(">>> Entering setCategoryId(categoryId={})", categoryId);
}
