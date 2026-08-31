package com.jobportal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobportal.dto.LocationDTO;
import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "locationClient", url = "https://maps.googleapis.com/maps/api/geocode/json?key=${google.maps.apiKey}")
@Slf4j
public interface LocationClient {
	log.debug(">>> Entering findByAddress()");
	
	@GetMapping
    LocationDTO findByAddress(@RequestParam String address);

log.debug("<<< Exiting findByAddress()");
}
