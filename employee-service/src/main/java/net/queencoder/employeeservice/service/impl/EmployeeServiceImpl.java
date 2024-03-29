package net.queencoder.employeeservice.service.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.queencoder.employeeservice.dto.APIResponseDto;
import net.queencoder.employeeservice.dto.DepartmentDto;
import net.queencoder.employeeservice.dto.EmployeeDto;
import net.queencoder.employeeservice.dto.OrganizationDto;
import net.queencoder.employeeservice.entity.Employee;
import net.queencoder.employeeservice.exception.EmailAlreadyExistException;
import net.queencoder.employeeservice.exception.ResourceNotFoundException;
import net.queencoder.employeeservice.mapper.EmployeeMapper;
import net.queencoder.employeeservice.repository.EmployeeRepository;
import net.queencoder.employeeservice.service.APIClient;
import net.queencoder.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    // private RestTemplate restTemplate;

    private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

         Optional<Employee> optionalUser = employeeRepository.findByEmail(employeeDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistException("Email Already exists for User");
        }

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
        
        return savedEmployeeDto;
    }

    //@CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long id) {
        log.info("Inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        // ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
        //     "http://localhost:8080/api/departments/"+employee.getDepartmentCode(), 
        //     DepartmentDto.class);

        // DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient.get()
        .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
        .retrieve()
        .bodyToMono(DepartmentDto.class)
        .block();

    //    DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

    OrganizationDto organizationDto = webClient.get()
        .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
        .retrieve()
        .bodyToMono(OrganizationDto.class)
        .block();
        log.info("organizationDto Code {}", organizationDto);
         EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
         
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganzation(organizationDto);

        return apiResponseDto;

    }
    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception){
        log.info("Inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD0001");
        departmentDto.setDepartmentDescription("Research and Development Department");

         EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);


        return apiResponseDto;
    }
    
}
