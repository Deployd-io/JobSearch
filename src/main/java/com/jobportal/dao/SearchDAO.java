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


@Repository
@Slf4j
public class SearchDAO {
	
	@Autowired
	MongoTemplate template;

	public <T> List<T> searchByTerm(Class className, String term, Pageable p)
	{
		log.debug(">>> Entering searchByTerm(Class className={},String term={},Pageable p={})", Class className, String term, Pageable p);
		long start = System.currentTimeMillis();
		TextCriteria criteria = TextCriteria.forDefaultLanguage()
				.matchingAny(term.split("\\s+"));  // handles multiple words

		Query query = new Query()
				.with(Sort.by(Sort.Direction.DESC, "updatedOn"))
				.with(p);

		List<T> result = template.find(query, className);

		log.debug("searchByTerm(Class className={},String term={},Pageable p={}): result → {}", Class className, String term, Pageable p, result);
		log.debug("<<< Exiting searchByTerm(Class className={},String term={},Pageable p={})", Class className, String term, Pageable p);
		log.info("searchByTerm(Class className,String term,Pageable p)={},{},{}: find query executed in {} ms", Class className, String term, Pageable p, (System.currentTimeMillis() - start));
		return result;
	}
}
