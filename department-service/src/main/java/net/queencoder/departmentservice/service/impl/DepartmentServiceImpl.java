package net.queencoder.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.queencoder.departmentservice.dto.DepartmentDto;
import net.queencoder.departmentservice.entity.Department;
import net.queencoder.departmentservice.mapper.DepartmentMapper;
import net.queencoder.departmentservice.repository.DepartmentRepository;
import net.queencoder.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        
        Department department =  DepartmentMapper.mapToDepartment(departmentDto);

        Department savDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto =  DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
    
}
