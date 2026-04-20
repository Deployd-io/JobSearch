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
		log.debug(">>> Entering findById(id={})", id);
		Optional<Proposal> optProposal = dao.findById(id);
		long start = System.currentTimeMillis();
		
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		if (!optProposal.isPresent())
			return null;
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optProposal.get(), ProposalDTO.class);
	}
	
	public List<ProposalDTO> findByJobId(String jobId)
	{
		log.debug(">>> Entering findByJobId(jobId={})", jobId);
		log.debug("<<< Exiting findByJobId(jobId={})", jobId);
		return dao.findByJobId(jobId).stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public String createProposal(ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		Proposal proposal = modelMapper.map(proposalDTO, Proposal.class);
		long start = System.currentTimeMillis();
		proposal.setCreatedOn((new Date()).toString());
		proposal.setUpdatedOn(proposal.getCreatedOn());
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
		proposal.setPoint(point);
		
		dao.save(proposal);
		log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		
		//locationService.findByAddress(job.getProposalId(), jobDTO.getCompleteAddress());
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		
		return proposal.getProposalId();
	}
	
	
	@Transactional
	public void updateProposal(ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		Optional<Proposal> optProposal = dao.findById(proposalDTO.getProposalId());
		long start = System.currentTimeMillis();
		
		log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		if (!optProposal.isPresent())
			return;
			log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
		
		Proposal proposal = optProposal.get();
		log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		proposal.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		log.debug("updateProposal(proposalDTO={}): point → {}", proposalDTO, point);
		proposal.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(proposalDTO, proposal);
		
		dao.save(proposal);
		log.info("updateProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
	}
}
