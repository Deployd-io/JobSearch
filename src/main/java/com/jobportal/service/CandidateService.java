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
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Slf4j
@Service
@Slf4j
public class CandidateService {

	@Autowired
	CandidateDAO dao;
	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	
	@Autowired
	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	ModelMapper modelMapper;
	
	log.debug(">>> Entering findById(id={})", id);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	log.debug("findById(id={}): optCndt → {}", id, optCndt);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	@Autowired
	ModelMapperService modelMapperService;
	log.debug(">>> Entering findById(id={})", id);
	log.debug("<<< Exiting findById(id={})", id);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	log.debug("findById(id={}): optCndt → {}", id, optCndt);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
	long start = System.currentTimeMillis();
	
	log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
	long start = System.currentTimeMillis();
	log.debug("<<< Exiting findAll()");
	
	log.debug(">>> Entering findById(id={})", id);
	log.debug("<<< Exiting findById(id={})", id);
	log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findAll()");
	log.debug("findById(id={}): optCndt → {}", id, optCndt);
	log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
	log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
	long start = System.currentTimeMillis();
	long start = System.currentTimeMillis();
	log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
	long start = System.currentTimeMillis();
	public List<CandidateDTO> findAll()
	{
	log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
	long start = System.currentTimeMillis();
	log.debug("<<< Exiting findAll()");
		log.debug(">>> Entering findAll()");
		log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		log.debug("<<< Exiting findById(id={})", id);
		log.debug("findById(id={}): optCndt → {}", id, optCndt);
		long start = System.currentTimeMillis();
		log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting findAll()");
		log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		return dao.findAll().stream().map(cndt -> 
			modelMapper.map(cndt, CandidateDTO.class)).collect(Collectors.toList());
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
			log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
			log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
			long start = System.currentTimeMillis();
	}
	log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
	long start = System.currentTimeMillis();
	log.debug(">>> Entering findById(id={})", id);
	log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
	long start = System.currentTimeMillis();
	log.info("updateCandidate(cndtDTO)={}: find query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting findById(id={})", id);
	long start = System.currentTimeMillis();
	
	log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
	log.debug("findById(id={}): optCndt → {}", id, optCndt);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
	log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
	log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
	long start = System.currentTimeMillis();
	public CandidateDTO findById(String id)
	{
	log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
	long start = System.currentTimeMillis();
		log.debug(">>> Entering findById(id={})", id);
		Optional<Candidate> optCndt = dao.findById(id);
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
		long start = System.currentTimeMillis();
		
		log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		log.debug("<<< Exiting findById(id={})", id);
		if (!optCndt.isPresent())
			return null;
			log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		
		return modelMapper.map(optCndt.get(), CandidateDTO.class);
	}
	log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
	log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
	long start = System.currentTimeMillis();
	
	log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
	long start = System.currentTimeMillis();
	log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
	log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
	log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
	long start = System.currentTimeMillis();
	@Transactional
	public String createCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering createCandidate(cndtDTO={})", cndtDTO);
		log.debug("createCandidate(cndtDTO={}): point → {}", cndtDTO, point);
		Candidate cndt = modelMapper.map(cndtDTO, Candidate.class);
		cndt.setCreatedOn((new Date()).toString());
		cndt.setUpdatedOn(cndt.getCreatedOn());
		log.debug("createCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		log.info("createCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		log.debug("<<< Exiting createCandidate(cndtDTO={})", cndtDTO);
		cndt.setPoint(point);
		log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		
		dao.save(cndt);
		
		return cndt.getCandidateId();
	}
	log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
	log.debug("updateCandidate(cndtDTO={}): optCndt → {}", cndtDTO, optCndt);
	long start = System.currentTimeMillis();
	
	
	@Transactional
	public void updateCandidate(CandidateDTO cndtDTO)
	{
		log.debug(">>> Entering updateCandidate(cndtDTO={})", cndtDTO);
		Optional<Candidate> optCndt = dao.findById(cndtDTO.getCandidateId());
		
		if (!optCndt.isPresent())
			return;
			log.debug("updateCandidate(cndtDTO={}): cndt → {}", cndtDTO, cndt);
		
		Candidate cndt = optCndt.get();
		cndt.setUpdatedOn((new Date()).toString());
		
		log.info("updateCandidate(cndtDTO)={}: save query executed in {} ms", cndtDTO, (System.currentTimeMillis() - start));
		Point point = new Point(cndtDTO.getLng(), cndtDTO.getLat());
		cndt.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(cndtDTO, cndt);
		
		dao.save(cndt);
	}

}
