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
import lombok.extern.slf4j.Slf4j;
@Slf4j
import lombok.extern.slf4j.Slf4j;
@Slf4j

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
	
	log.debug(">>> Entering findAll()");
	@Autowired
	LocationService locationService;
	log.debug(">>> Entering findAll()");
	
	
	log.debug(">>> Entering findAll()");
	log.debug(">>> Entering findById(id={})", id);
	long start = System.currentTimeMillis();
	public List<ProposalDTO> findAll()
	{
		log.debug("<<< Exiting findAll()");
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		log.debug("findById(id={}): optProposal → {}", id, optProposal);
		log.debug(">>> Entering findById(id={})", id);
		long start = System.currentTimeMillis();
		log.debug(">>> Entering findAll()");
		log.debug("<<< Exiting findById(id={})", id);
		log.debug("<<< Exiting findAll()");
		return dao.findAll().stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
		log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
		log.debug(">>> Entering findByJobId(jobId={})", jobId);
		log.debug("findById(id={}): optProposal → {}", id, optProposal);
			log.debug(">>> Entering findById(id={})", id);
			long start = System.currentTimeMillis();
			log.debug("<<< Exiting findById(id={})", id);
	}
	
	public ProposalDTO findById(String id)
	{
	log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
	log.debug(">>> Entering findByJobId(jobId={})", jobId);
	log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
	long start = System.currentTimeMillis();
	log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
	log.debug("findById(id={}): optProposal → {}", id, optProposal);
		log.debug(">>> Entering findById(id={})", id);
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		long start = System.currentTimeMillis();
		log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
		log.debug("<<< Exiting findById(id={})", id);
		Optional<Proposal> optProposal = dao.findById(id);
		
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		if (!optProposal.isPresent())
			log.info("findById(id)={}: find query executed in {} ms", id, (System.currentTimeMillis() - start));
			log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
			long start = System.currentTimeMillis();
			log.debug(">>> Entering findByJobId(jobId={})", jobId);
			log.debug("findById(id={}): optProposal → {}", id, optProposal);
			return null;
			log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
			log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
			long start = System.currentTimeMillis();
			log.debug("<<< Exiting findByJobId(jobId={})", jobId);
			log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
		
		log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
		log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		log.debug("<<< Exiting findById(id={})", id);
		return modelMapper.map(optProposal.get(), ProposalDTO.class);
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
	}
	
	log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
	log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
	log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
	log.debug("updateProposal(proposalDTO={}): point → {}", proposalDTO, point);
	public List<ProposalDTO> findByJobId(String jobId)
	{
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		long start = System.currentTimeMillis();
		log.info("updateProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		log.debug(">>> Entering findByJobId(jobId={})", jobId);
		log.debug("<<< Exiting findByJobId(jobId={})", jobId);
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		return dao.findByJobId(jobId).stream().map(proposal -> 
			modelMapper.map(proposal, ProposalDTO.class)).collect(Collectors.toList());
			log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
			log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
			log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
			log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
			log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	}
	log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
	
	log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
	@Transactional
	public String createProposal(ProposalDTO proposalDTO)
	{
		log.debug("updateProposal(proposalDTO={}): point → {}", proposalDTO, point);
		log.debug(">>> Entering createProposal(proposalDTO={})", proposalDTO);
		log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		Proposal proposal = modelMapper.map(proposalDTO, Proposal.class);
		proposal.setCreatedOn((new Date()).toString());
		log.info("updateProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		log.debug("createProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		long start = System.currentTimeMillis();
		proposal.setUpdatedOn(proposal.getCreatedOn());
		
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		log.debug("createProposal(proposalDTO={}): point → {}", proposalDTO, point);
		log.info("createProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
		log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		proposal.setPoint(point);
		
		dao.save(proposal);
		
		log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		//locationService.findByAddress(job.getProposalId(), jobDTO.getCompleteAddress());
		
		log.debug("<<< Exiting createProposal(proposalDTO={})", proposalDTO);
		log.debug("updateProposal(proposalDTO={}): point → {}", proposalDTO, point);
		return proposal.getProposalId();
		log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	}
	
	
	log.info("updateProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
	@Transactional
	public void updateProposal(ProposalDTO proposalDTO)
	{
		log.debug(">>> Entering updateProposal(proposalDTO={})", proposalDTO);
		long start = System.currentTimeMillis();
		Optional<Proposal> optProposal = dao.findById(proposalDTO.getProposalId());
		
		if (!optProposal.isPresent())
			log.debug("updateProposal(proposalDTO={}): optProposal → {}", proposalDTO, optProposal);
			log.info("updateProposal(proposalDTO)={}: find query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
			return;
		
		Proposal proposal = optProposal.get();
		proposal.setUpdatedOn((new Date()).toString());
		log.debug("updateProposal(proposalDTO={}): proposal → {}", proposalDTO, proposal);
		
		Point point = new Point(proposalDTO.getLng(), proposalDTO.getLat());
		proposal.setPoint(point);
		log.debug("updateProposal(proposalDTO={}): point → {}", proposalDTO, point);
		
		modelMapperService.getNonNullModelMapper().map(proposalDTO, proposal);
		
		dao.save(proposal);
		log.info("updateProposal(proposalDTO)={}: save query executed in {} ms", proposalDTO, (System.currentTimeMillis() - start));
		log.debug("<<< Exiting updateProposal(proposalDTO={})", proposalDTO);
	}
}
