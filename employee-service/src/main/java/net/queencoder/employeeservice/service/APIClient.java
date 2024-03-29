package net.queencoder.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.queencoder.employeeservice.dto.DepartmentDto;

// @FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE") used before we added load balancer
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
     @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);
}
