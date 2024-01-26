package net.queencoder.employeeservice.service;

import net.queencoder.employeeservice.dto.APIResponseDto;
import net.queencoder.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
