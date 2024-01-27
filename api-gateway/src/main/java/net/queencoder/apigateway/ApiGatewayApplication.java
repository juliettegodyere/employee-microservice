package net.queencoder.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ApiGatewayApplication.class);
		application.setAdditionalProfiles("local");
		application.run(args);
	}

}
