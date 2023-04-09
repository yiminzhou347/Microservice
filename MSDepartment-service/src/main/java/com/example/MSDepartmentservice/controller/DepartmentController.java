package com.example.MSDepartmentservice.controller;

import com.example.MSDepartmentservice.entity.Department;
import com.example.MSDepartmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;



    @PostMapping("/")
    public Department save(@RequestBody Department department){
        log.info("Inside saveDepartment of Department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id){
        return departmentService.findDepartmentById(id);
    }

}
