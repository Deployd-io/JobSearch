package com.jobportal.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.Job;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public interface JobDAO extends MongoRepository<Job, String> {
	log.debug(">>> Entering findByContactEmail()");
	
	public List<Job> findByContactEmail(String contactEmail);

log.debug("<<< Exiting findByContactEmail()");
}
