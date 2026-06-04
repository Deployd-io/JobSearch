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
		log.debug(">>> Entering findById(String id={})", String id);
		Optional<Employer> optEmp = dao.findById(id);
		
		log.info("findById(String id)={}: find query executed in {} ms", String id, (System.currentTimeMillis() - start));
		log.debug("findById(String id={}): optEmp → {}", String id, optEmp);
		long start = System.currentTimeMillis();
		if (!optEmp.isPresent())
			return null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in findById(String id={}): {}", String id, e.getMessage(), e);
		}
		test2 = "tesst 2";
		log.debug("findById(String id={}): test2 → {}", String id, test2);
		e.setEmail("a@yahoo.com");
		log.debug("findById(String id={}): e → {}", String id, e);
		
		log.debug("<<< Exiting findById(String id={})", String id);
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering createEmployer(EmployerDTO empDTO={})", EmployerDTO empDTO);
		Employer emp = modelMapper.map(empDTO, Employer.class);
		emp.setCreatedOn((new Date()).toString());
		long start = System.currentTimeMillis();
		log.debug("createEmployer(EmployerDTO empDTO={}): emp → {}", EmployerDTO empDTO, emp);
		emp.setUpdatedOn(emp.getCreatedOn());
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		log.debug("createEmployer(EmployerDTO empDTO={}): point → {}", EmployerDTO empDTO, point);
		
		dao.save(emp);
		log.info("createEmployer(EmployerDTO empDTO)={}: save query executed in {} ms", EmployerDTO empDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting createEmployer(EmployerDTO empDTO={})", EmployerDTO empDTO);
		
		return emp.getEmployerId();
	}
	
	
	@Transactional
	public void updateEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering updateEmployer(EmployerDTO empDTO={})", EmployerDTO empDTO);
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		
		log.info("updateEmployer(EmployerDTO empDTO)={}: find query executed in {} ms", EmployerDTO empDTO, (System.currentTimeMillis() - start));
		log.debug("updateEmployer(EmployerDTO empDTO={}): optEmp → {}", EmployerDTO empDTO, optEmp);
		long start = System.currentTimeMillis();
		if (!optEmp.isPresent())
			return;

		Employer emp = null;
		try {
			emp = optEmp.get();
			emp.setUpdatedOn((new Date()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in updateEmployer(EmployerDTO empDTO={}): {}", EmployerDTO empDTO, e.getMessage(), e);
		}
		
		test3 = 29;
		log.debug("updateEmployer(EmployerDTO empDTO={}): test3 → {}", EmployerDTO empDTO, test3);
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		log.debug("updateEmployer(EmployerDTO empDTO={}): emp → {}", EmployerDTO empDTO, emp);
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		
		dao.save(emp);
		log.info("updateEmployer(EmployerDTO empDTO)={}: save query executed in {} ms", EmployerDTO empDTO, (System.currentTimeMillis() - start));
	}

	public boolean validateEmployer(String employerId)
	{
		log.debug(">>> Entering validateEmployer(String employerId={})", String employerId);
		long start = System.currentTimeMillis();
		ResponseEntity<EmployerDTO> response = restTemplate
				.getForEntity(kycValidatorUrl, EmployerDTO.class, employerId);
		if (response.getStatusCode() == HttpStatus.OK) {
			log.info("validateEmployer(String employerId)={}: external service call {} took {} ms", String employerId, kycValidatorUrl, (System.currentTimeMillis() - start));
			return true;
		}

		log.debug("<<< Exiting validateEmployer(String employerId={})", String employerId);
		return false;
	}

}
