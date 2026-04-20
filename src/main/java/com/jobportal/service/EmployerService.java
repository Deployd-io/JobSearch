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
		long start = System.currentTimeMillis();
		Optional<Employer> optEmp = dao.findById(id);
		
		log.debug("findById(id={}): optEmp → {}", id, optEmp);
		log.info("findById(id)={}): executed in {} ms", id, (System.currentTimeMillis() - start));
		if (!optEmp.isPresent())
			return null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
		}
		test2 = "tesst 2";
		log.debug("findById(id={}): test2 → {}", id, test2);
		e.setEmail("a@yahoo.com");
		
		log.debug("findById(id={}): e → {}", id, e);
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		Employer emp = modelMapper.map(empDTO, Employer.class);
		emp.setCreatedOn((new Date()).toString());
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		emp.setUpdatedOn(emp.getCreatedOn());
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
		emp.setPoint(point);
		
		dao.save(emp);
		log.info("createEmployer(empDTO)={}): executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		return emp.getEmployerId();
	}
	
	
	@Transactional
	public void updateEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		
		log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
		if (!optEmp.isPresent())
			return;

		Employer emp = null;
		try {
			emp = optEmp.get();
			log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
			emp.setUpdatedOn((new Date()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		}
		
		test3 = 29;
		log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		log.debug("updateEmployer(empDTO={}): point → {}", empDTO, point);
		emp.setPoint(point);
		log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		
		log.debug("<<< Exiting updateEmployer(empDTO={})", empDTO);
		dao.save(emp);
		log.info("updateEmployer(empDTO)={}): executed in {} ms", empDTO, (System.currentTimeMillis() - start));
	}

	public boolean validateEmployer(String employerId)
	{
		log.debug(">>> Entering validateEmployer(employerId={})", employerId);
		long start = System.currentTimeMillis();
		ResponseEntity<EmployerDTO> response = restTemplate
				.getForEntity(kycValidatorUrl, EmployerDTO.class, employerId);
				log.debug("validateEmployer(employerId={}): employerId → {}", employerId, employerId);
		if (response.getStatusCode() == HttpStatus.OK) {
			return true;
		}

		log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
		return false;
	}

}
