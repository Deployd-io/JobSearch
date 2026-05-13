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
		log.debug(">>> Entering EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
        this.mongoTemplate = mongoTemplate;
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.mongoTemplate → {}", mongoTemplate, objectMapper, this.mongoTemplate);
        this.objectMapper = objectMapper;
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.objectMapper → {}", mongoTemplate, objectMapper, this.objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.mongoTemplate → {}", mongoTemplate, objectMapper, this.mongoTemplate);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.objectMapper → {}", mongoTemplate, objectMapper, this.objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
    }

    @PostConstruct
    public void loadEmployers() throws Exception {
	log.debug(">>> Entering loadEmployers()");
	log.debug("loadEmployers(): is → {}", is);

        if (mongoTemplate.getCollection("employer").countDocuments() > 0) {
            return;
        }

        InputStream is = new ClassPathResource("employers.json").getInputStream();
        List<Employer> employers =
                objectMapper.readValue(is, new TypeReference<List<Employer>>() {});
				log.debug("loadEmployers(): is → {}", is);

        mongoTemplate.insert(employers, Employer.class);

        log.info("Loaded {} employers into embedded MongoDB", employers.size());
		log.debug("<<< Exiting loadEmployers()");
    }
}

