package net.queencoder.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.queencoder.departmentservice.dto.DepartmentDto;
import net.queencoder.departmentservice.service.DepartmentService;

@Tag(
    name = "Department Service - DepartmentController",
    description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    
    private DepartmentService departmentService;

    @Operation(
        summary = "Save Department REST API",
        description = " Save Department REST API is used to save department object in a database"
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

     @Operation(
        summary = "Get Department REST API",
        description = " Get Department REST API is used to get department object from the database"
    )
    @ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {
        DepartmentDto savedDepartment = departmentService.getDepartmentByCode(departmentCode);

        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }
}
