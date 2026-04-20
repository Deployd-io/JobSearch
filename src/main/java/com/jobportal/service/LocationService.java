package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jobportal.client.LocationClient;
import lombok.extern.slf4j.Slf4j;
import com.jobportal.dto.LocationDTO;

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
		LocationDTO location = locationClient.findByAddress(address);
		
		jobService.updateLocation(jobId, location);
		log.debug("<<< Exiting findByAddress(jobId={},address={})", jobId, address);
	}
}
