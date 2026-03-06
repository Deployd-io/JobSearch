package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jobportal.client.LocationClient;
import com.jobportal.dto.LocationDTO;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
import lombok.extern.slf4j.Slf4j;
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j

log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
@Service
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
@Slf4j
public class LocationService {
log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);

	@Autowired
	log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
	log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
	log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
	private LocationClient locationClient;
	
	log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
	log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
	log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
	@Autowired
	JobService jobService;
	log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
	log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
	log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
	
	@Async
	log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
	log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
	log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
	public void findByAddress(String jobId, String address)
	{
		log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
		log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
		log.debug(">>> Entering findByAddress(String jobId={},String address={})", String jobId, String address);
		LocationDTO location = locationClient.findByAddress(address);
		
		log.debug("findByAddress(String jobId={},String address={}): location → {}", String jobId, String address, location);
		log.debug("<<< Exiting findByAddress(String jobId={},String address={})", String jobId, String address);
		jobService.updateLocation(jobId, location);
	}
}
