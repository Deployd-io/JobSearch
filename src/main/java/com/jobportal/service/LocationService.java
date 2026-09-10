package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jobportal.client.LocationClient;
import com.jobportal.dto.LocationDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LocationService {

	@Autowired
	private LocationClient locationClient;
	
	@Autowired
	JobService jobService;
	
	@Async
	public void findByAddress(String jobId, String address)
	{
		log.debug(">>> Entering findByAddress(jobId={},address={})", jobId, address);
		// SUGGESTED FIX (review before applying): log.debug(">>> Entering ***(jobId={},***={})", jobId, ***);
		LocationDTO location = locationClient.findByAddress(address);
		
		log.debug("findByAddress(jobId={},address={}): location → {}", jobId, address, location);
		// SUGGESTED FIX (review before applying): log.debug("***(jobId={},***={}): location → {}", jobId, ***, location);
		jobService.updateLocation(jobId, location);
		log.debug("<<< Exiting findByAddress(jobId={},address={})", jobId, address);
		// SUGGESTED FIX (review before applying): log.debug("<<< Exiting ***(jobId={},***={})", jobId, ***);
	}
}
