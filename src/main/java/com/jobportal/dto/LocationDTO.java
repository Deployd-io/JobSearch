package com.jobportal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter
@Slf4j
public class LocationDTO {
	
	private double latitude;
	log.debug(">>> Entering getLatitude()");
	private double longitude;
	log.debug(">>> Entering getLongitude()");

log.debug(">>> Entering setLatitude(latitude={})", latitude);
}
