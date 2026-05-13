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
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Slf4j
@Component
@Slf4j
public class MongoJsonDataLoader {

	log.debug(">>> Entering MongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;
	log.debug("<<< Exiting MongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
	log.debug(">>> Entering MongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
	log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.mongoTemplate → {}", mongoTemplate, objectMapper, this.mongoTemplate);
	log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);

    public MongoJsonDataLoader(MongoTemplate mongoTemplate, ObjectMapper objectMapper) {
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.objectMapper → {}", mongoTemplate, objectMapper, this.objectMapper);
		log.debug("<<< Exiting MongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug(">>> Entering loadData()");
		log.debug(">>> Entering MongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.mongoTemplate → {}", mongoTemplate, objectMapper, this.mongoTemplate);
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
        this.mongoTemplate = mongoTemplate;
        this.objectMapper = objectMapper;
		log.debug("loadData(): jobs → {}", jobs);
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.objectMapper → {}", mongoTemplate, objectMapper, this.objectMapper);
		log.debug("loadData(): is → {}", is);
		log.debug("<<< Exiting MongoJsonDataLoader(mongoTemplate={},objectMapper={})", mongoTemplate, objectMapper);
		log.debug(">>> Entering loadData()");
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.mongoTemplate → {}", mongoTemplate, objectMapper, this.mongoTemplate);
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): objectMapper → {}", mongoTemplate, objectMapper, objectMapper);
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): this.objectMapper → {}", mongoTemplate, objectMapper, this.objectMapper);
		log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
    }

	log.debug("loadData(): is → {}", is);
    @PostConstruct
    public void loadData() throws Exception {
		log.debug(">>> Entering loadData()");
        if (mongoTemplate.getCollection("job").countDocuments() > 0) {
			log.debug("MongoJsonDataLoader(mongoTemplate={},objectMapper={}): mongoTemplate → {}", mongoTemplate, objectMapper, mongoTemplate);
            return;
        }

        InputStream is = new ClassPathResource("jobs.json").getInputStream();
		log.debug("loadData(): jobs → {}", jobs);
		log.debug("loadData(): is → {}", is);
        List<Job> jobs = objectMapper.readValue(is, new TypeReference<List<Job>>() {});
        mongoTemplate.insert(jobs, Job.class);
		log.debug("<<< Exiting loadData()");
    }
}

