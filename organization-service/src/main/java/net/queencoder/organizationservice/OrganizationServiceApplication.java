package net.queencoder.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(OrganizationServiceApplication.class, args);
		SpringApplication application = new SpringApplication(OrganizationServiceApplication.class);
		application.setAdditionalProfiles("local");
		application.run(args);
	}

}
