package com.jobportal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dao.CandidateDAO;
import com.jobportal.model.Candidate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidateReportService {

	@Autowired
	CandidateDAO dao;

	public Map<String, Integer> countByJobType() {
		log.info(">>> Entering countByJobType()");
		long start = System.currentTimeMillis();
		List<Candidate> candidates = dao.findAll();
		Map<String, Integer> counts = new HashMap<>();
		log.info("countByJobType(): find query executed in {} ms", (System.currentTimeMillis() - start));
		log.debug("countByJobType(): counts → {}", counts);
		for (Candidate candidate : candidates) {
			String type = candidate.getDesiredJobType() == null ? "UNKNOWN" : candidate.getDesiredJobType();
			log.debug("countByJobType(): type → {}", type);
			log.debug("countByJobType(): candidates → {}", candidates);
			counts.merge(type, 1, Integer::sum);
			log.info("countByJobType(): update query executed in {} ms", (System.currentTimeMillis() - start));
		}
		log.info("<<< Exiting countByJobType()");
		return counts;
	}

	public String topJobType() {
		log.info(">>> Entering topJobType()");
		Map<String, Integer> counts = countByJobType();
		String best = null;
		log.debug("topJobType(): counts → {}", counts);
		int bestCount = -1;
		log.debug("topJobType(): bestCount → {}", bestCount);
		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			if (entry.getValue() > bestCount) {
				best = entry.getKey();
				log.debug("topJobType(): best → {}", best);
				bestCount = entry.getValue();
			}
		}
		log.info("<<< Exiting topJobType()");
		return best;
	}
}
