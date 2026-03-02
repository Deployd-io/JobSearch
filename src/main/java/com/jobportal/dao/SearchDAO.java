package com.jobportal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Slf4j

@Slf4j
@Repository
@Slf4j
public class SearchDAO {
	log.debug(">>> Entering searchByTerm(className={},term={},p={})", className, term, p);
	long start = System.currentTimeMillis();
	
	@Autowired
	log.debug(">>> Entering searchByTerm(className={},term={},p={})", className, term, p);
	log.debug("<<< Exiting searchByTerm(className={},term={},p={})", className, term, p);
	log.debug("searchByTerm(className={},term={},p={}): result → {}", className, term, p, result);
	log.info("searchByTerm(className,term,p)={},{},{}: find query executed in {} ms", className, term, p, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	MongoTemplate template;

	log.debug(">>> Entering searchByTerm(className={},term={},p={})", className, term, p);
	log.debug("<<< Exiting searchByTerm(className={},term={},p={})", className, term, p);
	log.debug("searchByTerm(className={},term={},p={}): result → {}", className, term, p, result);
	log.info("searchByTerm(className,term,p)={},{},{}: find query executed in {} ms", className, term, p, (System.currentTimeMillis() - start));
	long start = System.currentTimeMillis();
	public <T> List<T> searchByTerm(Class className, String term, Pageable p)
	{
		log.debug(">>> Entering searchByTerm(className={},term={},p={})", className, term, p);
		TextCriteria criteria = TextCriteria.forDefaultLanguage()
				.matchingAny(term.split("\\s+"));  // handles multiple words
				log.debug("<<< Exiting searchByTerm(className={},term={},p={})", className, term, p);

		Query query = new Query()
				.with(Sort.by(Sort.Direction.DESC, "updatedOn"))
				.with(p);
				log.debug("searchByTerm(className={},term={},p={}): result → {}", className, term, p, result);
				log.info("searchByTerm(className,term,p)={},{},{}: find query executed in {} ms", className, term, p, (System.currentTimeMillis() - start));

		List<T> result = template.find(query, className);

		return result;
	}
}
