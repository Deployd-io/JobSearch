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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Slf4j
public class CandidateService {

	@Autowired
	CandidateDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ModelMapperService modelMapperService;
	
	
	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	public List<CandidateDTO> findAll()
	{
		log.debug("<<< Exiting findAll()");
		log.info("findAll(): find query executed in {} ms", (System.currentTimeMillis() - start));
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, CandidateDTO.class)).collect(Collectors.toList());
			long start = System.currentTimeMillis();
			log.debug("findById(id={}): optCndt → {}", id, optCndt);
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	}
	
	public CandidateDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		log.debug("<<< Exiting findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Candidate> optCndt = dao.findById(id);
		
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		log.debug("findById(id={}): optCndt → {}", id, optCndt);
		log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		long start = System.currentTimeMillis();
		if (!optCndt.isPresent())
			return null;
			log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optCndt.get(), CandidateDTO.class);
	}
	log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
	
	@Transactional
	log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	public String createCandidate(CandidateDTO cndtDTO)
	{
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		long start = System.currentTimeMillis();
		Candidate cndt = modelMapper.map(cndtDTO, Candidate.class);
		cndt.setCreatedOn((new Date()).toString());
		log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		cndt.setUpdatedOn(cndt.getCreatedOn());
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		long start = System.currentTimeMillis();
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
		log.info("updateCandidate(cndtDTO)={}: find query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		cndt.setPoint(point);
		
		dao.save(cndt);
		log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		log.debug("updateCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		return cndt.getCandidateId();
	}
	
	
	@Transactional
	log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting updateCandidate(cndtDTO={})", cndtDTO);
	public void updateCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		long start = System.currentTimeMillis();
		Optional<Candidate> optCndt = dao.findById(cndtDTO.getCandidateId());
		
		log.info("updateCandidate(cndtDTO)={}: find query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
		if (!optCndt.isPresent())
			return;
		
		Candidate cndt = optCndt.get();
		log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		cndt.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		log.debug("updateCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		cndt.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(cndtDTO, cndt);
		
		dao.save(cndt);
		log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateCandidate(cndtDTO={})", cndtDTO);
	}

}
