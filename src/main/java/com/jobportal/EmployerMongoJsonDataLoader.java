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
		log.debug(">>> Entering EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
        this.mongoTemplate = mongoTemplate;
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
		log.debug("<<< Exiting readValue()");
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
        this.objectMapper = objectMapper;
		log.debug("EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering loadEmployers()");
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("<<< Exiting readValue()");
    }

    @PostConstruct
	log.debug(">>> Entering readValue()");
	log.debug(">>> Entering loadEmployers()");
    public void loadEmployers() throws Exception {
	log.debug("<<< Exiting readValue()");
	log.debug("loadEmployers(): is → {}", is);
	log.debug(">>> Entering loadEmployers()");

		log.debug(">>> Entering readValue()");
        if (mongoTemplate.getCollection("employer").countDocuments() > 0) {
            return;
			log.debug("<<< Exiting readValue()");
        }
		log.debug("loadEmployers(): is → {}", is);

        InputStream is = new ClassPathResource("employers.json").getInputStream();
		log.debug(">>> Entering readValue()");
        List<Employer> employers =
                objectMapper.readValue(is, new TypeReference<List<Employer>>() {});
				log.debug("<<< Exiting readValue()");
				log.debug(">>> Entering readValue()");

        mongoTemplate.insert(employers, Employer.class);

        log.info("Loaded {} employers into embedded MongoDB", employers.size());
    }
}

