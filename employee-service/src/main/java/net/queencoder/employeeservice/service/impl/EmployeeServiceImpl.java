package net.queencoder.employeeservice.service.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import net.queencoder.employeeservice.dto.APIResponseDto;
import net.queencoder.employeeservice.dto.DepartmentDto;
import net.queencoder.employeeservice.dto.EmployeeDto;
import net.queencoder.employeeservice.entity.Employee;
import net.queencoder.employeeservice.exception.EmailAlreadyExistException;
import net.queencoder.employeeservice.exception.ResourceNotFoundException;
import net.queencoder.employeeservice.repository.EmployeeRepository;
import net.queencoder.employeeservice.service.APIClient;
import net.queencoder.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    // private RestTemplate restTemplate;

    //private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

         Optional<Employee> optionalUser = employeeRepository.findByEmail(employeeDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistException("Email Already exists for User");
        }

        Employee employee = new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail(),
            employeeDto.getDepartmentCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
            savedEmployee.getId(),
            savedEmployee.getFirstName(),
            savedEmployee.getLastName(),
            savedEmployee.getEmail(),
            savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        // ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
        //     "http://localhost:8080/api/departments/"+employee.getDepartmentCode(), 
        //     DepartmentDto.class);

        // DepartmentDto departmentDto = responseEntity.getBody();

        // DepartmentDto departmentDto = webClient.get()
        // .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
        // .retrieve()
        // .bodyToMono(DepartmentDto.class)
        // .block();

       DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

         EmployeeDto employeeDto = new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail(),
            employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);


        return apiResponseDto;

    }
    
}
