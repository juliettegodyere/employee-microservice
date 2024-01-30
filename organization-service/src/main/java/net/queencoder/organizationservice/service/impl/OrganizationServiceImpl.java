package net.queencoder.organizationservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.queencoder.organizationservice.dto.OrganizationDto;
import net.queencoder.organizationservice.entity.Organization;
import net.queencoder.organizationservice.mapper.OrganizationMapper;
import net.queencoder.organizationservice.repository.OrganizationRepository;
import net.queencoder.organizationservice.service.OrganizationService;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        //Convert OrganizatioDto to Organization JPA entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization saveOrganization = organizationRepository.save(organization);


       return OrganizationMapper.mapToOrganizationDto(saveOrganization);
    }
    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        Organization organization = organizationRepository.findByOrganizationCode(code).orElseThrow(() -> new RuntimeException("Organization code " + code));
      return OrganizationMapper.mapToOrganizationDto(organization);
    }
    
}
