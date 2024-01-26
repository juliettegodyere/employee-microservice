package net.queencoder.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DepartmentServiceApplication.class);
		application.setAdditionalProfiles("local");
		application.run(args);
	}

}
