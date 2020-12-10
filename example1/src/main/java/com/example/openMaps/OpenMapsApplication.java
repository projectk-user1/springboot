package com.example.openMaps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
// un comment to bypass 
@SpringBootApplication
public class OpenMapsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenMapsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
