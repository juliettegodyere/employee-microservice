package net.queencoder.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info(
		title = "Organisation Service REST APIs",
		description = "Organisation Service REST API's Documentation",
		version = "v1.0",
		contact = @Contact(
			name = "Queencoder",
			email = "queencoder@gmail.com",
			url = "https://www.queencoder.com"
		),
		license = @License(
			name = "Apache 2.0",
			url = "https://www.queencoder.com"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "Organisation-service Doc",
		url = "https://www.queencoder.com"
	)
)
@SpringBootApplication
@EnableDiscoveryClient
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(OrganizationServiceApplication.class, args);
		SpringApplication application = new SpringApplication(OrganizationServiceApplication.class);
		application.setAdditionalProfiles("local");
		application.run(args);
	}

}
