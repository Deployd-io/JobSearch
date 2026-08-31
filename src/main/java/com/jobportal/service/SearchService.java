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

@Service
@Slf4j
public class SearchService {
	
	@Autowired
	SearchDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<JobDTO> searchJobsByTerm(String term, Pageable p)
	{
		log.debug(">>> Entering searchJobsByTerm(term={},p={})", term, p);
		log.debug("<<< Exiting searchJobsByTerm(term={},p={})", term, p);
		return dao.searchByTerm(Job.class, term, p).stream().map(job -> 
			modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}
	
	public List<CandidateDTO> searchCandidatesByTerm(String term, Pageable p)
	{
		log.debug(">>> Entering searchCandidatesByTerm(term={},p={})", term, p);
		log.debug("<<< Exiting searchCandidatesByTerm(term={},p={})", term, p);
		return dao.searchByTerm(Candidate.class, term, p).stream().map(cndt ->
			modelMapper.map(cndt, CandidateDTO.class)).collect(Collectors.toList());
	}

	// --- Error simulation: ClassCastException ---
	public String applyDynamicFilter(String filterValue)
	{
		log.debug(">>> Entering applyDynamicFilter(filterValue={})", filterValue);
		try {
			if (filterValue == null || filterValue.isEmpty()) {
				log.error("applyDynamicFilter(filterValue={}): invalid filter value - empty or null", filterValue);
				return "applyDynamicFilter failed: invalid filter value";
			}
			try {
				Integer cast = Integer.parseInt(filterValue);
				return "filter=" + cast;
			} catch (NumberFormatException e) {
				log.error("applyDynamicFilter(filterValue={}): invalid filter type - not an integer", filterValue, e.getMessage(), e);
				return "applyDynamicFilter failed: invalid filter type";
			}
		} catch (Exception e) {
			log.error("applyDynamicFilter(filterValue={}): unexpected error - {}", filterValue, e.getMessage(), e);
			return "applyDynamicFilter failed: unexpected error";
		}
	}

}