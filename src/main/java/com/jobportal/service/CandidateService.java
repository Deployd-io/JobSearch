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
	
	
	public List<CandidateDTO> findAll()
	{
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, CandidateDTO.class)).collect(Collectors.toList());
	}
	
	public CandidateDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Candidate> optCndt = dao.findById(id);
		
		if (!optCndt.isPresent())
			return null;
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optCndt.get(), CandidateDTO.class);
	}
	
	@Transactional
	public String createCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		long start = System.currentTimeMillis();
		Candidate cndt = modelMapper.map(cndtDTO, Candidate.class);
		cndt.setCreatedOn((new Date()).toString());
		cndt.setUpdatedOn(cndt.getCreatedOn());
		log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		cndt.setPoint(point);
		log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		
		dao.save(cndt);
		
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		return cndt.getCandidateId();
	}
	
	
	@Transactional
	public void updateCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
		long start = System.currentTimeMillis();
		Optional<Candidate> optCndt = dao.findById(cndtDTO.getCandidateId());
		
		if (!optCndt.isPresent())
			return;
		
		Candidate cndt = optCndt.get();
		cndt.setUpdatedOn((new Date()).toString());
		log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		cndt.setPoint(point);
		log.debug("updateCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		
		modelMapperService.getNonNullModelMapper().map(cndtDTO, cndt);
		
		dao.save(cndt);
		log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	}

}
