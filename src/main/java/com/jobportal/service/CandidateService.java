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
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, CandidateDTO.class)).collect(Collectors.toList());
	}
	
	public CandidateDTO findById(String id)
	{
		log.debug(">>> Entering findById(String id={})", String id);
		Optional<Candidate> optCndt = dao.findById(id);
		
		log.info("findById(String id)={}: find query executed in {} ms", String id, (System.currentTimeMillis() - start));
		log.debug("findById(String id={}): optCndt → {}", String id, optCndt);
		long start = System.currentTimeMillis();
		if (!optCndt.isPresent())
			return null;
		
		log.debug("<<< Exiting findById(String id={})", String id);
		return modelMapper.map(optCndt.get(), CandidateDTO.class);
	}
	
	@Transactional
	public String createCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering createCandidate(CandidateDTO cndtDTO={})", CandidateDTO cndtDTO);
		Candidate cndt = modelMapper.map(cndtDTO, Candidate.class);
		cndt.setCreatedOn((new Date()).toString());
		long start = System.currentTimeMillis();
		log.debug("createCandidate(CandidateDTO cndtDTO={}): cndt → {}", CandidateDTO cndtDTO, cndt);
		cndt.setUpdatedOn(cndt.getCreatedOn());
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		cndt.setPoint(point);
		log.debug("createCandidate(CandidateDTO cndtDTO={}): point → {}", CandidateDTO cndtDTO, point);
		
		dao.save(cndt);
		log.info("createCandidate(CandidateDTO cndtDTO)={}: save query executed in {} ms", CandidateDTO cndtDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting createCandidate(CandidateDTO cndtDTO={})", CandidateDTO cndtDTO);
		
		return cndt.getCandidateId();
	}
	
	
	@Transactional
	public void updateCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering updateCandidate(CandidateDTO cndtDTO={})", CandidateDTO cndtDTO);
		Optional<Candidate> optCndt = dao.findById(cndtDTO.getCandidateId());
		
		log.info("updateCandidate(CandidateDTO cndtDTO)={}: find query executed in {} ms", CandidateDTO cndtDTO, (System.currentTimeMillis() - start));
		log.debug("updateCandidate(CandidateDTO cndtDTO={}): optCndt → {}", CandidateDTO cndtDTO, optCndt);
		long start = System.currentTimeMillis();
		if (!optCndt.isPresent())
			return;
		
		Candidate cndt = optCndt.get();
		cndt.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		cndt.setPoint(point);
		log.debug("updateCandidate(CandidateDTO cndtDTO={}): cndt → {}", CandidateDTO cndtDTO, cndt);
		
		modelMapperService.getNonNullModelMapper().map(cndtDTO, cndt);
		
		dao.save(cndt);
		log.info("updateCandidate(CandidateDTO cndtDTO)={}: save query executed in {} ms", CandidateDTO cndtDTO, (System.currentTimeMillis() - start));
	}

}
