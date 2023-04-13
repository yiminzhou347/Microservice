package com.example.userservice.service;

import com.example.userservice.VO.Attachment;
import com.example.userservice.VO.Department;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("attachment")
    private RestTemplate restTemplate;


    @Autowired
    @Qualifier("department")
    private RestTemplate restTemplateDepartment;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithAttachment(Long id) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(id);


        Department department = restTemplateDepartment.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                Department.class);
        Attachment attachment=restTemplate.getForObject("http://localhost:9001/download/"+user.getAttachmentId(),
                Attachment.class);
        vo.setUser(user);
        vo.setAttachment(attachment);
        vo.setDepartment(department);

        return vo;

    }
}
