package com.jobportal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		log.info(">>> Entering main(args={})", args);
		SpringApplication.run(DemoApplication.class, args);
		log.info("<<< Exiting main(args={})", args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		log.info(">>> Entering modelMapper()");
	    ModelMapper result = new ModelMapper();
		log.info("<<< Exiting modelMapper() -> {}", result);
	    return result;
	}

    @Bean
    public RestTemplate restTemplate() {
		log.info(">>> Entering restTemplate()");
        RestTemplate result = new RestTemplate();
		log.info("<<< Exiting restTemplate() -> {}", result);
        return result;
    }

}
