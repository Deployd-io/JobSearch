package com.jobportal.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.Proposal;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public interface ProposalDAO extends MongoRepository<Proposal, String> {
	log.debug(">>> Entering findByJobId()");
	
	public List<Proposal> findByJobId(String jobId);

log.debug("<<< Exiting findByJobId()");
}
