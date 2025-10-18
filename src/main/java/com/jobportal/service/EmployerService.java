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
import lombok.extern.slf4j.Slf4j;


@Slf4j
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
	
	
	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	public List<EmployerDTO> findAll()
	{
		log.debug("<<< Exiting findAll()");
		log.info("findAll(): find query executed in {} ms", (System.currentTimeMillis() - start));
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, EmployerDTO.class)).collect(Collectors.toList());
			long start = System.currentTimeMillis();
			log.debug("findById(id={}): optEmp → {}", id, optEmp);
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	}
	
	public EmployerDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Employer> optEmp = dao.findById(id);
		
		log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
		log.debug("findById(id={}): optEmp → {}", id, optEmp);
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		log.debug("findById(id={}): test2 → {}", id, test2);
		if (!optEmp.isPresent())
			return null;
			log.debug("findById(id={}): e → {}", id, e);
		
		log.debug("<<< Exiting findById(id={})", id);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
			log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
			long start = System.currentTimeMillis();
		}
		test2 = "tesst 2";
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		log.debug("findById(id={}): test2 → {}", id, test2);
		e.setEmail("a@yahoo.com");
		
		log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
		log.debug("findById(id={}): e → {}", id, e);
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
	log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		Employer emp = modelMapper.map(empDTO, Employer.class);
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		emp.setCreatedOn((new Date()).toString());
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
		log.info("updateEmployer(empDTO)={}: find query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		emp.setUpdatedOn(emp.getCreatedOn());
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
		emp.setPoint(point);
		
		log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
		dao.save(emp);
		log.info("createEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		
		log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		return emp.getEmployerId();
	}
	log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
	
	
	log.debug("updateEmployer(empDTO={}): point → {}", empDTO, point);
	@Transactional
	log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
	public void updateEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		log.info("updateEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateEmployer(empDTO={})", empDTO);
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		
		log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
		log.info("updateEmployer(empDTO)={}: find query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		log.debug(">>> Entering validateEmployer(employerId={})", employerId);
		long start = System.currentTimeMillis();
		if (!optEmp.isPresent())
			return;

		log.info("validateEmployer(employerId)={}: external service call {} took {} ms", employerId, kycValidatorUrl, (System.currentTimeMillis() - start));
		Employer emp = null;
		try {
			emp = optEmp.get();
			log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
			log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
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
		
		dao.save(emp);
		log.info("updateEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateEmployer(empDTO={})", empDTO);
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
