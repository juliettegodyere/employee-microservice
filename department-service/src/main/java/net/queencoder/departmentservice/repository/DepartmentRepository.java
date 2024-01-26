package net.queencoder.departmentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.queencoder.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Department findByDepartmentCode(String departmentCode);
}
