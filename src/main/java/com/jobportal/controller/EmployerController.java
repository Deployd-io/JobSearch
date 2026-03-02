package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.EmployerDTO;
import com.jobportal.service.EmployerService;
import com.jobportal.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employers")
@Slf4j
@CrossOrigin("*")
@Slf4j
public class EmployerController {
	
	@Autowired
	EmployerService employerService;
	
	@Autowired
	SearchService searchService;
	
	
	@GetMapping
	log.debug(">>> Entering findAll()");
	public List<EmployerDTO> findAll()
	{
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		log.debug("<<< Exiting findAll()");
		return employerService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public EmployerDTO findById(@PathVariable( "id" ) String id)
	{
		return employerService.findById(id);
	}
	log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
	
	@PostMapping
	public String createEmployer(@RequestBody EmployerDTO empDTO)
	{
	log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		return employerService.createEmployer(empDTO);
	}
	log.debug("<<< Exiting updateEmployer(empDTO={})", empDTO);
	
	@PutMapping
	public void updateEmployer(@RequestBody EmployerDTO empDTO)
	{
		log.debug(">>> Entering validateEmployer()");
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		employerService.updateEmployer(empDTO);
		log.debug("validateEmployer(): isValid → {}", isValid);
		log.debug("<<< Exiting updateEmployer(empDTO={})", empDTO);
	}

    @GetMapping("/{employerId}/validate")
    public ResponseEntity<Boolean> validateEmployer(
            @PathVariable String employerId) {
			log.debug(">>> Entering validateEmployer()");

        boolean isValid = employerService.validateEmployer(employerId);
		log.debug("validateEmployer(): isValid → {}", isValid);
		log.debug("<<< Exiting validateEmployer()");
        return ResponseEntity.ok(isValid);
    }
}
