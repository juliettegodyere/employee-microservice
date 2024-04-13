# Employee Microservice
This repository houses a comprehensive microservices project developed using a stack that includes Spring Boot and Spring Cloud for the backend, React for the frontend, Kafka and RabbitMQ for messaging, REST API for communication, Docker for containerization, MySQL for database management, and VS Code as the integrated development environment (IDE). The project is designed to showcase the integration and utilization of various cutting-edge technologies, emphasizing modularity, scalability, and efficient communication between services. Feel free to explore the codebase and contribute to the ongoing development of this microservices ecosystem.

## Microservices
- Department-service
- Employee-service
- Organization-service

## Cloud Services
- Service registry using Netflix EurekaServer
- API Gateway
- Config Server
- Spring Cloud Bus
- Distributed tracing with Micrometer and Zipkin
- Circuit Breaker with Resilience4J

## API Communication
The employee-service communicates with the department-service using @FeignClient.  

## Frontend
React 

## Swagger API Documentation Test URLs
- http://localhost:8080/swagger-ui/index.html - DEPARTMENT-SERVICE
- http://localhost:8081/swagger-ui/index.html - EMPLOYEE-SERVICE
- http://localhost:8083/swagger-ui/index.html - ORGANISATION-SERVICE

## Others
1. Used Spring Cloud Config Server Encryption and Decryption feature to manage pushing sensitive data to Github. https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_encryption_and_decryption
