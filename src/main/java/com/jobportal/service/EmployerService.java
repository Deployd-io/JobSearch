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

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(EmployerService.class);

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
		logger.info(">>> Entering findAll");
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		logger.info("<<< Exiting findAll");
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, EmployerDTO.class)).collect(Collectors.toList());
	}
	
	public EmployerDTO findById(String id)
	{
		logger.info(">>> Entering findById");
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Employer> optEmp = dao.findById(id);
		log.debug("findById(id={}): optEmp → {}", id, optEmp);
		long queryStart = System.currentTimeMillis();
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - queryStart));
		
		if (!optEmp.isPresent()) {
			logger.info("<<< Exiting findById - not found");
			return null;
		}
		
		try {
			log.debug("<<< Exiting findById(id={})", id);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in findById(id={}): {}", id, e.getMessage(), e);
		}
		test2 = "tesst 2";
		log.debug("findById(id={}): test2 → {}", id, test2);
		e.setEmail("a@yahoo.com");
		log.debug("findById(id={}): e → {}", id, e);
		
		logger.info("<<< Exiting findById");
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
		logger.info(">>> Entering createEmployer");
		log.debug(">>> Entering createEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		Employer emp = modelMapper.map(empDTO, Employer.class);
		log.debug("createEmployer(empDTO={}): emp → {}", empDTO, emp);
		long saveStart = System.currentTimeMillis();
		emp.setCreatedOn((new Date()).toString());
		emp.setUpdatedOn(emp.getCreatedOn());
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		log.debug("createEmployer(empDTO={}): point → {}", empDTO, point);
		emp.setPoint(point);
		
		dao.save(emp);
		log.info("createEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - saveStart));
		
		logger.info("<<< Exiting createEmployer");
		log.debug("<<< Exiting createEmployer(empDTO={})", empDTO);
		return emp.getEmployerId();
	}
	
	
	@Transactional
	public void updateEmployer(EmployerDTO empDTO)
	{
		logger.info(">>> Entering updateEmployer");
		log.debug(">>> Entering updateEmployer(empDTO={})", empDTO);
		long start = System.currentTimeMillis();
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		log.debug("updateEmployer(empDTO={}): optEmp → {}", empDTO, optEmp);
		long queryStart = System.currentTimeMillis();
		log.info("updateEmployer(empDTO)={}: find query executed in {} ms", empDTO, (System.currentTimeMillis() - queryStart));
		
		if (!optEmp.isPresent()) {
			logger.info("<<< Exiting updateEmployer - not found");
			return;
		}

		Employer emp = null;
		try {
			emp = optEmp.get();
			emp.setUpdatedOn((new Date()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in updateEmployer(empDTO={}): {}", empDTO, e.getMessage(), e);
		}
		
		test3 = 29;
		log.debug("updateEmployer(empDTO={}): test3 → {}", empDTO, test3);
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		log.debug("updateEmployer(empDTO={}): emp → {}", empDTO, emp);
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		
		dao.save(emp);
		log.info("updateEmployer(empDTO)={}: save query executed in {} ms", empDTO, (System.currentTimeMillis() - start));
		logger.info("<<< Exiting updateEmployer");
	}
	
	public boolean validateEmployer(String employerId)
	{
		logger.info(">>> Entering validateEmployer");
		log.debug(">>> Entering validateEmployer(employerId={})", employerId);
		long start = System.currentTimeMillis();
		ResponseEntity<EmployerDTO> response = restTemplate
				.getForEntity(kycValidatorUrl, EmployerDTO.class, employerId);
		if (response.getStatusCode() == HttpStatus.OK) {
			log.info("validateEmployer(employerId)={}: external service call {} took {} ms", employerId, kycValidatorUrl, (System.currentTimeMillis() - start));
			logger.info("<<< Exiting validateEmployer - success");
			return true;
		}

		logger.info("<<< Exiting validateEmployer - failure");
		return false;
	}
}