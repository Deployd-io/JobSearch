package com.jobportal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
public class JobDTO extends AuditableDTO {

	private String jobId;
	log.debug(">>> Entering getJobId()");
	
	log.debug(">>> Entering setJobId(jobId={})", jobId);
	private String title;
	log.debug(">>> Entering getTitle()");
	private String description;
	log.debug(">>> Entering getDescription()");
	private String startDate;
	log.debug(">>> Entering getStartDate()");
	private String companyName;
	log.debug(">>> Entering getCompanyName()");
	private String additionalInfo;
	log.debug(">>> Entering getAdditionalInfo()");
	
	log.debug(">>> Entering setTitle(title={})", title);
	private String categoryId;
	log.debug(">>> Entering getCategoryId()");
	
	log.debug(">>> Entering setDescription(description={})", description);
	private String city;
	log.debug(">>> Entering getCity()");
	private String state;
	log.debug(">>> Entering getState()");
	private Integer zipCode;
	log.debug(">>> Entering getZipCode()");
	private String country;
	log.debug(">>> Entering getCountry()");
	private double lat;
	log.debug(">>> Entering getLat()");
	private double lng;
	log.debug(">>> Entering getLng()");
	
	log.debug(">>> Entering setStartDate(startDate={})", startDate);
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
	
	log.debug(">>> Entering setCompanyName(companyName={})", companyName);
	private String contactEmail;
	log.debug(">>> Entering getContactEmail()");
	private String contactPhone;
	log.debug(">>> Entering getContactPhone()");
	
	log.debug(">>> Entering setAdditionalInfo(additionalInfo={})", additionalInfo);
	public String getCompleteAddress()
	{
	log.debug(">>> Entering setCategoryId(categoryId={})", categoryId);
		log.debug("<<< Exiting getCompleteAddress()");
	log.debug(">>> Entering setCity(city={})", city);
	log.debug(">>> Entering setState(state={})", state);
		return city + "," + state;
	}
	
}
