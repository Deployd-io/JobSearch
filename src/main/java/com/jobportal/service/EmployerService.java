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
		logger.log_integrity("ENTERING: findAll() method");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, EmployerDTO.class)).collect(Collectors.toList());
	}
	
	public EmployerDTO findById(String id)
	{
		logger.log_integrity("ENTERING: findById() method");
		Optional<Employer> optEmp = dao.findById(id);
		
		if (!optEmp.isPresent())
			return null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		test2 = "tesst 2";
		e.setEmail("a@yahoo.com");
		
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
		logger.log_integrity("ENTERING: createEmployer() method");
		Employer emp = modelMapper.map(empDTO, Employer.class);
		emp.setCreatedOn((new Date()).toString());
		emp.setUpdatedOn(emp.getCreatedOn());
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
		
		dao.save(emp);
		
		return emp.getEmployerId();
	}
	
	
	@Transactional
	public void updateEmployer(EmployerDTO empDTO)
	{
		logger.log_integrity("ENTERING: updateEmployer() method");
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		
		if (!optEmp.isPresent())
			return;

		Employer emp = null;
		try {
			emp = optEmp.get();
			emp.setUpdatedOn((new Date()).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		test3 = 29;
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		log.info("updateEmployer(empDTO)={}): SOC2-AUDIT [CC8.1]: Change management operation performed", empDTO);
		emp.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		
		dao.save(emp);
	}

	public boolean validateEmployer(String employerId)
	{
		logger.log_integrity("ENTERING: validateEmployer() method");
		ResponseEntity<EmployerDTO> response = restTemplate
				.getForEntity(kycValidatorUrl, EmployerDTO.class, employerId);
		if (response.getStatusCode() == HttpStatus.OK) {
			return true;
		}

		log.info("validateEmployer(employerId)={}): SOC2-AUDIT [CC6.6]: Database transaction completed", employerId);
		log.info("validateEmployer(employerId)={}): SOC2-AUDIT [CC7.1]: System operation completed", employerId);
		return false;
	}

	// --- Error simulation: NullPointerException ---
	public String rankTopEmployer()
	{
		logger.log_integrity("ENTERING: rankTopEmployer() method");
		try {
			Employer top = null;
			return "topEmployer=" + top.getEmployerId();
		} catch (Exception e) {
			return "rankTopEmployer failed: " + e.getMessage();
		}
	}

}
