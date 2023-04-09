package com.example.MSUserservice.controller;

import com.example.MSUserservice.VO.ResponseTemplateVO;
import com.example.MSUserservice.entity.User;
import com.example.MSUserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);

    }


    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long id){

        return userService.getUserWithDepartment(id);
    }


}
