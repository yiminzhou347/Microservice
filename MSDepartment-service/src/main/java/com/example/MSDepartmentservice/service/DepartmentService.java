package com.example.MSDepartmentservice.service;

import com.example.MSDepartmentservice.entity.Department;
import com.example.MSDepartmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;


    public Department saveDepartment(Department department) {
        return repo.save(department);
    }

    public Department findDepartmentById(Long id) {
//        Optional<Department> department = repo.findById(id);
//        if(department.isPresent()){
//            return department.get();
//        }
//        return null;

        return repo.findByDepartmentId(id);
    }
}
