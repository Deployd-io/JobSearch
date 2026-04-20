package com.jobportal.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.dao.EmployerDAO;
import com.jobportal.dto.EmployerDTO;
import com.jobportal.model.Employer;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployerService {

	@Autowired
	EmployerDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ModelMapperService modelMapperService;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${kycValidator.url:http://kycValidator.com/validate}")
	private String kycValidatorUrl;

	Integer test;
	String test2;
	int test3;
	Employer e;
	
	
	public List<EmployerDTO> findAll()
	{
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, EmployerDTO.class)).collect(Collectors.toList());
	}
	
	public EmployerDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		Optional<Employer> optEmp = dao.findById(id);
		
		if (!optEmp.isPresent())
			return null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
		}
		test2 = "tesst 2";
		e.setEmail("a@yahoo.com");
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
		Employer emp = modelMapper.map(empDTO, Employer.class);
		emp.setCreatedOn((new Date()).toString());
		emp.setUpdatedOn(emp.getCreatedOn());
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		
		dao.save(emp);
		
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		return emp.getEmployerId();
	}
	
	
	@Transactional
	public void updateEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		
		if (!optEmp.isPresent())
			return;

		Employer emp = null;
		try {
			emp = optEmp.get();
			emp.setUpdatedOn((new Date()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		}
		
		test3 = 29;
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		
		log.debug("<<< Exiting updateEmployer(empDTO={})", empDTO);
		dao.save(emp);
	}

	public boolean validateEmployer(String employerId)
	{
		log.debug(">>> Entering validateEmployer(employerId={})", employerId);
		ResponseEntity<EmployerDTO> response = restTemplate
				.getForEntity(kycValidatorUrl, EmployerDTO.class, employerId);
		if (response.getStatusCode() == HttpStatus.OK) {
			return true;
		}

		log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
		return false;
	}

}
