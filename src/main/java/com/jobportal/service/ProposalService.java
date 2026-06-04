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
	
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProposalService.class);
	
	public List<ProposalDTO> findAll()
	{
		logger.info(">>> Entering findAll");
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		logger.info("<<< Exiting findAll");
		return dao.findAll().stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
	}
	
	public ProposalDTO findById(String id)
	{
		logger.info(">>> Entering findById");
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Proposal> optProposal = dao.findById(id);
		log.debug("findById(id={}): optProposal → {}", id, optProposal);
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		
		if (!optProposal.isPresent()) {
			logger.info("<<< Exiting findById");
			return null;
		}
		
		logger.info("<<< Exiting findById");
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optProposal.get(), ProposalDTO.class);
	}
	
	public List<ProposalDTO> findByJobId(String jobId)
	{
		logger.info(">>> Entering findByJobId");
		log.debug(">>> Entering findByJobId(jobId={})", jobId);
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findByJobId(jobId={})", jobId);
		logger.info("<<< Exiting findByJobId");
		return dao.findByJobId(jobId).stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public String createProposal(ProposalDTO proposalDTO)
	{
		logger.info(">>> Entering createProposal");
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		Proposal proposal = modelMapper.map(proposalDTO, Proposal.class);
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		proposal.setCreatedOn((new Date()).toString());
		proposal.setUpdatedOn(proposal.getCreatedOn());
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
		proposal.setPoint(point);
		
		dao.save(proposal);
		log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		
		//locationService.findByAddress(job.getProposalId(), jobDTO.getCompleteAddress());
		logger.info("<<< Exiting createProposal");
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		
		return proposal.getProposalId();
	}
	
	
	@Transactional
	public void updateProposal(ProposalDTO proposalDTO)
	{
		logger.info(">>> Entering updateProposal");
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		Optional<Proposal> optProposal = dao.findById(proposalDTO.getProposalId());
		log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
		log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		
		if (!optProposal.isPresent()) {
			logger.info("<<< Exiting updateProposal");
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
		logger.info("<<< Exiting updateProposal");
	}
}