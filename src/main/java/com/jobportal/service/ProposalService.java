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

import com.jobportal.dao.ProposalDAO;
import com.jobportal.dto.ProposalDTO;
import com.jobportal.model.Proposal;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProposalService {
	
	@Autowired
	ProposalDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ModelMapperService modelMapperService;
	
	@Autowired
	LocationService locationService;
	
	
	public List<ProposalDTO> findAll()
	{
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
	}
	
	public ProposalDTO findById(String id)
	{
		log.debug(">>> Entering findById(String id={})", String id);
		Optional<Proposal> optProposal = dao.findById(id);
		
		log.debug("findById(String id={}): optProposal → {}", String id, optProposal);
		long start = System.currentTimeMillis();
		if (!optProposal.isPresent())
			return null;
		
		log.debug("<<< Exiting findById(String id={})", String id);
		return modelMapper.map(optProposal.get(), ProposalDTO.class);
	}
	
	public List<ProposalDTO> findByJobId(String jobId)
	{
		log.debug(">>> Entering findByJobId(String jobId={})", String jobId);
		log.debug("<<< Exiting findByJobId(String jobId={})", String jobId);
		return dao.findByJobId(jobId).stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public String createProposal(ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering createProposal(ProposalDTO proposalDTO={})", ProposalDTO proposalDTO);
		Proposal proposal = modelMapper.map(proposalDTO, Proposal.class);
		proposal.setCreatedOn((new Date()).toString());
		log.debug("createProposal(ProposalDTO proposalDTO={}): proposal → {}", ProposalDTO proposalDTO, proposal);
		long start = System.currentTimeMillis();
		proposal.setUpdatedOn(proposal.getCreatedOn());
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		proposal.setPoint(point);
		log.debug("createProposal(ProposalDTO proposalDTO={}): point → {}", ProposalDTO proposalDTO, point);
		
		dao.save(proposal);
		log.info("createProposal(ProposalDTO proposalDTO)={}: save query executed in {} ms", ProposalDTO proposalDTO, (System.currentTimeMillis() - start));
		
		//locationService.findByAddress(job.getProposalId(), jobDTO.getCompleteAddress());
		
		log.debug("<<< Exiting createProposal(ProposalDTO proposalDTO={})", ProposalDTO proposalDTO);
		return proposal.getProposalId();
	}
	
	
	@Transactional
	public void updateProposal(ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering updateProposal(ProposalDTO proposalDTO={})", ProposalDTO proposalDTO);
		Optional<Proposal> optProposal = dao.findById(proposalDTO.getProposalId());
		
		log.debug("updateProposal(ProposalDTO proposalDTO={}): optProposal → {}", ProposalDTO proposalDTO, optProposal);
		long start = System.currentTimeMillis();
		if (!optProposal.isPresent())
			return;
		
		Proposal proposal = optProposal.get();
		proposal.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		proposal.setPoint(point);
		log.debug("updateProposal(ProposalDTO proposalDTO={}): proposal → {}", ProposalDTO proposalDTO, proposal);
		
		modelMapperService.getNonNullModelMapper().map(proposalDTO, proposal);
		
		dao.save(proposal);
		log.info("updateProposal(ProposalDTO proposalDTO)={}: save query executed in {} ms", ProposalDTO proposalDTO, (System.currentTimeMillis() - start));
	}
}
