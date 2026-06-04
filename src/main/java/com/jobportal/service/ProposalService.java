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
		log.info(">>> Entering findAll");
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		log.info("<<< Exiting findAll");
		return dao.findAll().stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
	}
	
	public ProposalDTO findById(String id)
	{
		log.info(">>> Entering findById");
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Proposal> optProposal = dao.findById(id);
		log.debug("findById(id={}): optProposal → {}", id, optProposal);
		long startQuery = System.currentTimeMillis();
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - startQuery));
		
		if (!optProposal.isPresent()) {
			log.info("<<< Exiting findById");
			return null;
		}
		
		log.debug("<<< Exiting findById(id={})", id);
		log.info("<<< Exiting findById");
		return modelMapper.map(optProposal.get(), ProposalDTO.class);
	}
	
	public List<ProposalDTO> findByJobId(String jobId)
	{
		log.info(">>> Entering findByJobId");
		log.debug(">>> Entering findByJobId(jobId={})", jobId);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findByJobId(jobId={})", jobId);
		log.info("<<< Exiting findByJobId");
		return dao.findByJobId(jobId).stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public String createProposal(ProposalDTO proposalDTO)
	{
		log.info(">>> Entering createProposal");
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		Proposal proposal = modelMapper.map(proposalDTO, Proposal.class);
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		long startSave = System.currentTimeMillis();
		proposal.setCreatedOn((new Date()).toString());
		proposal.setUpdatedOn(proposal.getCreatedOn());
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
		proposal.setPoint(point);
		
		dao.save(proposal);
		log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - startSave));
		
		//locationService.findByAddress(job.getProposalId(), jobDTO.getCompleteAddress());
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		log.info("<<< Exiting createProposal");
		return proposal.getProposalId();
	}
	
	
	@Transactional
	public void updateProposal(ProposalDTO proposalDTO)
	{
		log.info(">>> Entering updateProposal");
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		Optional<Proposal> optProposal = dao.findById(proposalDTO.getProposalId());
		log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
		long startQuery = System.currentTimeMillis();
		log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - startQuery));
		
		if (!optProposal.isPresent()) {
			log.info("<<< Exiting updateProposal");
			return;
		}
		
		Proposal proposal = optProposal.get();
		proposal.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		proposal.setPoint(point);
		log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		
		modelMapperService.getNonNullModelMapper().map(proposalDTO, proposal);
		
		dao.save(proposal);
		log.info("updateProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		log.info("<<< Exiting updateProposal");
	}
}