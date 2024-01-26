package net.queencoder.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ServiceRegistryApplication.class);
		application.setAdditionalProfiles("local");
		application.run(args);
	}

}
