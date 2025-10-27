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
		log.debug(">>> Entering findById(id={})", id);
		Optional<Candidate> optCndt = dao.findById(id);
		long start = System.currentTimeMillis();
		
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		if (!optCndt.isPresent())
			return null;
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optCndt.get(), CandidateDTO.class);
	}
	
	@Transactional
	public String createCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		Candidate cndt = modelMapper.map(cndtDTO, Candidate.class);
		long start = System.currentTimeMillis();
		cndt.setCreatedOn((new Date()).toString());
		cndt.setUpdatedOn(cndt.getCreatedOn());
		log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		cndt.setPoint(point);
		
		dao.save(cndt);
		log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		return cndt.getCandidateId();
	}
	
	
	@Transactional
	public void updateCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		Optional<Candidate> optCndt = dao.findById(cndtDTO.getCandidateId());
		long start = System.currentTimeMillis();
		
		log.info("updateCandidate(cndtDTO)={}: find query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		if (!optCndt.isPresent())
			return;
			log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
		
		Candidate cndt = optCndt.get();
		log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		cndt.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		log.debug("updateCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		cndt.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(cndtDTO, cndt);
		
		dao.save(cndt);
		log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	}

}
