package net.queencoder.organizationservice.controller;

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
import net.queencoder.organizationservice.dto.OrganizationDto;
import net.queencoder.organizationservice.service.OrganizationService;

@Tag(
    name = "Organisation Service - OrganisationController",
    description = "Organisation Controller Exposes REST APIs for Organisation-Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @Operation(
        summary = "Save Organisation REST API",
        description = " Save Organisation REST API is used to save organisation object in a database"
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto saveOrganizationDto = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(saveOrganizationDto, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Get Organisation REST API",
        description = " Get Organisation REST API is used to get organisation object from th database"
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String code){
        OrganizationDto saveOrganizationDto = organizationService.getOrganizationByCode(code);

        return new ResponseEntity<>(saveOrganizationDto, HttpStatus.OK);
    }
}
