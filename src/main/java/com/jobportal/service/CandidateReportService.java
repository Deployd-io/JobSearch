package com.jobportal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dao.CandidateDAO;
import com.jobportal.model.Candidate;

@Service
public class CandidateReportService {

	@Autowired
	CandidateDAO dao;

	public Map<String, Integer> countByJobType() {
		List<Candidate> candidates = dao.findAll();
		Map<String, Integer> counts = new HashMap<>();
		for (Candidate candidate : candidates) {
			String type = candidate.getDesiredJobType() == null ? "UNKNOWN" : candidate.getDesiredJobType();
			counts.merge(type, 1, Integer::sum);
		}
		return counts;
	}

	public String topJobType() {
		Map<String, Integer> counts = countByJobType();
		String best = null;
		int bestCount = -1;
		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			if (entry.getValue() > bestCount) {
				best = entry.getKey();
				bestCount = entry.getValue();
			}
		}
		return best;
	}
}
