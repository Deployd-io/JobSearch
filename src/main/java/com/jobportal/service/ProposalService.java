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
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	
	log.debug(">>> Entering findAll()");
	long start = System.currentTimeMillis();
	public List<ProposalDTO> findAll()
	{
		log.debug("<<< Exiting findAll()");
		log.info("findAll(): find query executed in {} ms", (System.currentTimeMillis() - start));
		log.debug(">>> Entering findAll()");
		long start = System.currentTimeMillis();
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
			long start = System.currentTimeMillis();
			log.debug("findById(id={}): optProposal → {}", id, optProposal);
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	}
	
	public ProposalDTO findById(String id)
	{
		log.debug(">>> Entering findById(id={})", id);
		log.debug("<<< Exiting findById(id={})", id);
		long start = System.currentTimeMillis();
		Optional<Proposal> optProposal = dao.findById(id);
		
		log.debug("findById(id={}): optProposal → {}", id, optProposal);
		log.debug(">>> Entering findByJobId(jobId={})", jobId);
		long start = System.currentTimeMillis();
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		if (!optProposal.isPresent())
			log.debug("<<< Exiting findByJobId(jobId={})", jobId);
			log.info("findByJobId(jobId)={}: find query executed in {} ms", jobId, (System.currentTimeMillis() - start));
			return null;
		
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optProposal.get(), ProposalDTO.class);
	}
	log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
	long start = System.currentTimeMillis();
	
	public List<ProposalDTO> findByJobId(String jobId)
	log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
	{
		log.debug(">>> Entering findByJobId(jobId={})", jobId);
		long start = System.currentTimeMillis();
		log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
		log.debug("<<< Exiting findByJobId(jobId={})", jobId);
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		return dao.findByJobId(jobId).stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
			log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
	}
	
	@Transactional
	public String createProposal(ProposalDTO proposalDTO)
	log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
	{
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		Proposal proposal = modelMapper.map(proposalDTO, Proposal.class);
		proposal.setCreatedOn((new Date()).toString());
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		proposal.setUpdatedOn(proposal.getCreatedOn());
		
		log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
		log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
		proposal.setPoint(point);
		
		log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		dao.save(proposal);
		log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		
		log.debug("updateProposal(proposalDTO={}): point → {}", proposalDTO, point);
		//locationService.findByAddress(job.getProposalId(), jobDTO.getCompleteAddress());
		
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		return proposal.getProposalId();
	}
	log.info("updateProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
	log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	
	
	@Transactional
	public void updateProposal(ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		Optional<Proposal> optProposal = dao.findById(proposalDTO.getProposalId());
		
		log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
		log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		if (!optProposal.isPresent())
			return;
		
		Proposal proposal = optProposal.get();
		log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		proposal.setUpdatedOn((new Date()).toString());
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		log.debug("updateProposal(proposalDTO={}): point → {}", proposalDTO, point);
		proposal.setPoint(point);
		
		modelMapperService.getNonNullModelMapper().map(proposalDTO, proposal);
		
		dao.save(proposal);
		log.info("updateProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	}
}
