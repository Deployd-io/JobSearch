package com.jobportal.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.dao.CandidateDAO;
import com.jobportal.dto.CandidateDTO;
import com.jobportal.model.Candidate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidateService {

	@Autowired
	CandidateDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ModelMapperService modelMapperService;
	
	// Simple logger wrapper to support logger.log calls
	private final SimpleLogger logger = new SimpleLogger();

	private static class SimpleLogger {
		void log(String message) {
			// Delegate to the Lombok-provided SLF4J logger at debug level
			CandidateService.log.debug(message);
		}
	}
	
	public List<CandidateDTO> findAll()
	{
		logger.log(">>> Entering findAll");
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		logger.log("<<< Exiting findAll");
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, CandidateDTO.class)).collect(Collectors.toList());
	}
	
	public CandidateDTO findById(String id)
	{
		logger.log(">>> Entering findById");
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Candidate> optCndt = dao.findById(id);
		log.debug("findById(id={}): optCndt → {}", id, optCndt);
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		
		if (!optCndt.isPresent()) {
			logger.log("<<< Exiting findById - not found");
			log.debug("<<< Exiting findById(id={})", id);
			return null;
		}
		
		logger.log("<<< Exiting findById");
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optCndt.get(), CandidateDTO.class);
	}
	
	@Transactional
	public String createCandidate(CandidateDTO cndtDTO)
	{
		logger.log(">>> Entering createCandidate");
		log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		long start = System.currentTimeMillis();
		Candidate cndt = modelMapper.map(cndtDTO, Candidate.class);
		log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		long saveStart = System.currentTimeMillis();
		cndt.setCreatedOn((new Date()).toString());
		cndt.setUpdatedOn(cndt.getCreatedOn());
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		cndt.setPoint(point);
		
		dao.save(cndt);
		log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - saveStart));
		
		logger.log("<<< Exiting createCandidate");
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		return cndt.getCandidateId();
	}
	
	
	@Transactional
	public void updateCandidate(CandidateDTO cndtDTO)
	{
		logger.log(">>> Entering updateCandidate");
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		long findStart = System.currentTimeMillis();
		Optional<Candidate> optCndt = dao.findById(cndtDTO.getCandidateId());
		log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
		long saveStart = System.currentTimeMillis();
		log.info("updateCandidate(cndtDTO)={}: find query executed in {} ms", cndtDTO, (System.currentTimeMillis() - findStart));
		
		if (!optCndt.isPresent()) {
			logger.log("<<< Exiting updateCandidate - not found");
			return;
		}
		
		Candidate cndt = optCndt.get();
		cndt.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		cndt.setPoint(point);
		log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		
		modelMapperService.getNonNullModelMapper().map(cndtDTO, cndt);
		
		dao.save(cndt);
		log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - saveStart));
		
		logger.log("<<< Exiting updateCandidate");
	}
	
}