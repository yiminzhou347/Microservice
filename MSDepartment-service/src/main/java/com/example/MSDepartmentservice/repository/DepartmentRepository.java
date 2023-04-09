package com.example.MSDepartmentservice.repository;

import com.example.MSDepartmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentId(Long id);
}
