package com.personal.user_center.controller;


import com.personal.user_center.entity.user.CloudUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserLoginController {

    @GetMapping("/findUser")
    public CloudUser findUser(String phone){
        CloudUser userInfo = new CloudUser();
        userInfo.setName("lisi");
        userInfo.setAge(32);
        return userInfo;
    }
}
