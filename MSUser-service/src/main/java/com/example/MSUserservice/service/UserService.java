package com.example.MSUserservice.service;

import com.example.MSUserservice.VO.Department;
import com.example.MSUserservice.VO.ResponseTemplateVO;
import com.example.MSUserservice.entity.User;
import com.example.MSUserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private RestTemplate restTemplate;


    public User save(User user) {
        return repo.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user = repo.findByUserId(userId);

        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;

    }
}
