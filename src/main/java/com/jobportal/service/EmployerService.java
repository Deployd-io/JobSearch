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
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, EmployerDTO.class)).collect(Collectors.toList());
	}
	
	public EmployerDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		Optional<Employer> optEmp = dao.findById(id);
		
		log.debug("findById(id={}): optEmp → {}", id, optEmp);
		long start = System.currentTimeMillis();
		if (!optEmp.isPresent())
			return null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
		}
		test2 = "tesst 2";
		e.setEmail("a@yahoo.com");
		log.debug("findById(id={}): test2 → {}", id, test2);
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
		Employer emp = modelMapper.map(empDTO, Employer.class);
		emp.setCreatedOn((new Date()).toString());
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		long start = System.currentTimeMillis();
		emp.setUpdatedOn(emp.getCreatedOn());
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
		
		dao.save(emp);
		log.info("createEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		return emp.getEmployerId();
	}
	
	
	@Transactional
	public void updateEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		
		log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
		if (!optEmp.isPresent())
			return;
			long start = System.currentTimeMillis();

		Employer emp = null;
		try {
			emp = optEmp.get();
			emp.setUpdatedOn((new Date()).toString());
			log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		}
		
		test3 = 29;
		
		log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		
		dao.save(emp);
		log.info("updateEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
	}

	public boolean validateEmployer(String employerId)
	{
		log.debug(">>> Entering validateEmployer(employerId={})", employerId);
		long start = System.currentTimeMillis();
		ResponseEntity<EmployerDTO> response = restTemplate
				.getForEntity(kycValidatorUrl, EmployerDTO.class, employerId);
		if (response.getStatusCode() == HttpStatus.OK) {
			log.info("validateEmployer(employerId)={}: external service call {} took {} ms", employerId, kycValidatorUrl, (System.currentTimeMillis() - start));
			return true;
		}

		log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
		return false;
	}

}
