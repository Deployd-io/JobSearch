package com.jobportal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jobportal.dao.SearchDAO;
import com.jobportal.dto.CandidateDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.model.Candidate;
import com.jobportal.model.Job;
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
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Slf4j
log.debug(">>> Entering searchJobsByTerm(term={},p={})", term, p);
@Service
@Slf4j
log.debug(">>> Entering searchJobsByTerm(term={},p={})", term, p);
public class SearchService {
	
	log.debug(">>> Entering searchJobsByTerm(term={},p={})", term, p);
	log.debug(">>> Entering searchCandidatesByTerm(term={},p={})", term, p);
	@Autowired
	SearchDAO dao;
	log.debug(">>> Entering searchJobsByTerm(term={},p={})", term, p);
	log.debug("<<< Exiting searchCandidatesByTerm(term={},p={})", term, p);
	log.debug(">>> Entering searchCandidatesByTerm(term={},p={})", term, p);
	
	@Autowired
	log.debug(">>> Entering searchJobsByTerm(term={},p={})", term, p);
	log.debug("<<< Exiting searchCandidatesByTerm(term={},p={})", term, p);
	log.debug(">>> Entering searchCandidatesByTerm(term={},p={})", term, p);
	ModelMapper modelMapper;
	
	log.debug(">>> Entering searchJobsByTerm(term={},p={})", term, p);
	log.debug("<<< Exiting searchCandidatesByTerm(term={},p={})", term, p);
	log.debug(">>> Entering searchCandidatesByTerm(term={},p={})", term, p);
	log.debug("<<< Exiting searchJobsByTerm(term={},p={})", term, p);
	public List<JobDTO> searchJobsByTerm(String term, Pageable p)
	{
		log.debug("<<< Exiting searchCandidatesByTerm(term={},p={})", term, p);
		log.debug(">>> Entering searchJobsByTerm(term={},p={})", term, p);
		log.debug(">>> Entering searchCandidatesByTerm(term={},p={})", term, p);
		log.debug("<<< Exiting searchJobsByTerm(term={},p={})", term, p);
		return dao.searchByTerm(Job.class, term, p).stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
			log.debug("<<< Exiting searchCandidatesByTerm(term={},p={})", term, p);
	}
	log.debug(">>> Entering searchCandidatesByTerm(term={},p={})", term, p);
	
	public List<CandidateDTO> searchCandidatesByTerm(String term, Pageable p)
	{
		log.debug("<<< Exiting searchCandidatesByTerm(term={},p={})", term, p);
		log.debug(">>> Entering searchCandidatesByTerm(term={},p={})", term, p);
		return dao.searchByTerm(Candidate.class, term, p).stream().map(cndt -> 
			modelMapper.map(cndt, CandidateDTO.class)).collect(Collectors.toList());
	}

}
