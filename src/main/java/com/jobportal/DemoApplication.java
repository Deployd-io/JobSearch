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
		logger.audit_coverage("ENTERING: main() method");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		logger.audit_coverage("ENTERING: modelMapper() method");
	    return new ModelMapper();
	}

    @Bean
    public RestTemplate restTemplate() {
		logger.audit_coverage("ENTERING: restTemplate() method");
        return new RestTemplate();
    }

}
