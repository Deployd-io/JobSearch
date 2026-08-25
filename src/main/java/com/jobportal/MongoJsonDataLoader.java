package com.jobportal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jobportal.model.Job;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MongoJsonDataLoader {

    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;

    public MongoJsonDataLoader(MongoTemplate mongoTemplate, ObjectMapper objectMapper) {
		logger.network_visibility("ENTERING: MongoJsonDataLoader() method");
        this.mongoTemplate = mongoTemplate;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadData() throws Exception {
        if (mongoTemplate.getCollection("job").countDocuments() > 0) {
			logger.log_integrity("ENTERING: loadData() method");
			logger.audit_coverage("ENTERING: loadData() method");
			logger.network_visibility("ENTERING: loadData() method");
            return;
        }

        InputStream is = new ClassPathResource("jobs.json").getInputStream();
        List<Job> jobs = objectMapper.readValue(is, new TypeReference<List<Job>>() {});
        mongoTemplate.insert(jobs, Job.class);
    }
}

