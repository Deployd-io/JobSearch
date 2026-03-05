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
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Slf4j

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
	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();

	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	Integer test;
	String test2;
	log.debug(">>> Entering findById(id={})", id);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	log.debug("findById(id={}): optEmp → {}", id, optEmp);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	int test3;
	Employer e;
	log.debug(">>> Entering findById(id={})", id);
	log.debug("<<< Exiting findById(id={})", id);
	log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
	log.debug("findById(id={}): test2 → {}", id, test2);
	log.debug("findById(id={}): e → {}", id, e);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	log.debug("findById(id={}): optEmp → {}", id, optEmp);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	
	log.debug("<<< Exiting findAll()");
	
	log.debug(">>> Entering findById(id={})", id);
	log.debug("<<< Exiting findById(id={})", id);
	log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
	log.debug("findById(id={}): test2 → {}", id, test2);
	log.debug("findById(id={}): e → {}", id, e);
	log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	log.debug("findById(id={}): optEmp → {}", id, optEmp);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
	long start = System.currentTimeMillis();
	public List<EmployerDTO> findAll()
	{
	log.info("createEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		log.debug("<<< Exiting findById(id={})", id);
		log.debug("findById(id={}): optEmp → {}", id, optEmp);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
		long start = System.currentTimeMillis();
		log.info("updateEmployer(empDTO)={}: find query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		long start = System.currentTimeMillis();
		log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, EmployerDTO.class)).collect(Collectors.toList());
			log.debug("findById(id={}): test2 → {}", id, test2);
			log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
	}
	log.debug("findById(id={}): e → {}", id, e);
	log.debug(">>> Entering findById(id={})", id);
	log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
	log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
	log.info("createEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting findById(id={})", id);
	log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
	log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
	log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
	log.debug("findById(id={}): test2 → {}", id, test2);
	log.debug("findById(id={}): e → {}", id, e);
	log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
	long start = System.currentTimeMillis();
	
	log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
	long start = System.currentTimeMillis();
	log.info("updateEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
	log.debug("findById(id={}): optEmp → {}", id, optEmp);
	log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
	long start = System.currentTimeMillis();
	log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
	log.debug(">>> Entering validateEmployer(employerId={})", employerId);
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.info("validateEmployer(employerId)={}: external service call {} took {} ms", employerId, kycValidatorUrl, (System.currentTimeMillis() - start));
	public EmployerDTO findById(String id)
	{
		log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
		log.debug(">>> Entering findById(id={})", id);
		log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
		Optional<Employer> optEmp = dao.findById(id);
		
		log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		log.info("createEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting findById(id={})", id);
		log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
		if (!optEmp.isPresent())
			log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
			return null;
			long start = System.currentTimeMillis();
		
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		long start = System.currentTimeMillis();
		log.info("updateEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering validateEmployer(employerId={})", employerId);
		long start = System.currentTimeMillis();
		try {
			
			log.debug("findById(id={}): test2 → {}", id, test2);
			log.info("validateEmployer(employerId)={}: external service call {} took {} ms", employerId, kycValidatorUrl, (System.currentTimeMillis() - start));
			log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
		} catch (Exception e) {
			log.debug("findById(id={}): e → {}", id, e);
			e.printStackTrace();
			log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
			log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
			log.info("createEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		}
		test2 = "tesst 2";
		log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		e.setEmail("a@yahoo.com");
		
		log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
	log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
	long start = System.currentTimeMillis();
	
	log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
	long start = System.currentTimeMillis();
	log.info("updateEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
	log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
	long start = System.currentTimeMillis();
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
	log.debug(">>> Entering validateEmployer(employerId={})", employerId);
	long start = System.currentTimeMillis();
		log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
		log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
		log.info("validateEmployer(employerId)={}: external service call {} took {} ms", employerId, kycValidatorUrl, (System.currentTimeMillis() - start));
		Employer emp = modelMapper.map(empDTO, Employer.class);
		emp.setCreatedOn((new Date()).toString());
		emp.setUpdatedOn(emp.getCreatedOn());
		log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		log.info("createEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		
		log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		emp.setPoint(point);
		log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
		
		dao.save(emp);
		
		return emp.getEmployerId();
	}
	log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
	log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering validateEmployer(employerId={})", employerId);
	long start = System.currentTimeMillis();
	
	
	@Transactional
	log.info("validateEmployer(employerId)={}: external service call {} took {} ms", employerId, kycValidatorUrl, (System.currentTimeMillis() - start));
	public void updateEmployer(EmployerDTO empDTO)
	{
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
		
		if (!optEmp.isPresent())
			return;

		log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		Employer emp = null;
		try {
			emp = optEmp.get();
			log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
			emp.setUpdatedOn((new Date()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
		}
		
		test3 = 29;
		
		log.info("updateEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		log.debug(">>> Entering validateEmployer(employerId={})", employerId);
		long start = System.currentTimeMillis();
		
		dao.save(emp);
	}

	public boolean validateEmployer(String employerId)
	{
		log.debug(">>> Entering validateEmployer(employerId={})", employerId);
		log.debug("<<< Exiting validateEmployer(employerId={})", employerId);
		ResponseEntity<EmployerDTO> response = restTemplate
				.getForEntity(kycValidatorUrl, EmployerDTO.class, employerId);
		if (response.getStatusCode() == HttpStatus.OK) {
			return true;
		}

		return false;
	}

}
