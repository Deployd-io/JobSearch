package com.jobportal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.model.Employer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;


@Component
@Slf4j
public class EmployerMongoJsonDataLoader {

    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;

    public EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate, ObjectMapper objectMapper) {
		log.network_visibility("ENTERING: EmployerMongoJsonDataLoader() method");
        this.mongoTemplate = mongoTemplate;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadEmployers() throws Exception {

		log.log_integrity("ENTERING: loadEmployers() method");
        if (mongoTemplate.getCollection("employer").countDocuments() > 0) {
			log.network_visibility("ENTERING: loadEmployers() method");
            return;
        }

        InputStream is = new ClassPathResource("employers.json").getInputStream();
        List<Employer> employers =
                objectMapper.readValue(is, new TypeReference<List<Employer>>() {});

        mongoTemplate.insert(employers, Employer.class);

        log.info("Loaded {} employers into embedded MongoDB", employers.size());
    }
}

