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
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug(">>> Entering EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering loadEmployers()");
        this.mongoTemplate = mongoTemplate;
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
        this.objectMapper = objectMapper;
		log.debug(">>> Entering loadEmployers()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): mongoTemplate → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, mongoTemplate);
		log.debug("<<< Exiting EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={})", MongoTemplate mongoTemplate, ObjectMapper objectMapper);
		log.debug("loadEmployers(): is → {}", is);
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering readValue()");
		log.debug("EmployerMongoJsonDataLoader(MongoTemplate mongoTemplate={},ObjectMapper objectMapper={}): objectMapper → {}", MongoTemplate mongoTemplate, ObjectMapper objectMapper, objectMapper);
		log.debug(">>> Entering loadEmployers()");
    }

	log.debug("loadEmployers(): is → {}", is);
    @PostConstruct
	log.debug(">>> Entering readValue()");
    public void loadEmployers() throws Exception {
	log.debug(">>> Entering loadEmployers()");

        if (mongoTemplate.getCollection("employer").countDocuments() > 0) {
			log.debug("loadEmployers(): is → {}", is);
            return;
			log.debug(">>> Entering readValue()");
        }

        InputStream is = new ClassPathResource("employers.json").getInputStream();
        List<Employer> employers =
                objectMapper.readValue(is, new TypeReference<List<Employer>>() {});
				log.debug("loadEmployers(): is → {}", is);

        mongoTemplate.insert(employers, Employer.class);

        log.info("Loaded {} employers into embedded MongoDB", employers.size());
    }
}

