package com.personal.user_center.controller;


import com.personal.user_center.entity.OmsOrder;
import com.personal.user_center.entity.user.CloudUser;
import com.personal.user_center.feign.ContentFeignInvoke;
import com.personal.user_center.service.CloudService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserLoginController {

    @Autowired
    private CloudService cloudService;
    @Autowired
    private ContentFeignInvoke contentFeignInvoke;

    @GetMapping("/findUser")
    public CloudUser findUser(String phone){
        CloudUser userInfo = new CloudUser();
        userInfo.setName("lisi");
        userInfo.setAge(32);
        return userInfo;
    }

    @PostMapping("/addUser")
    public CloudUser addUser(@RequestBody @Valid CloudUser userInfo){

        int i = cloudService.addUser(userInfo);
        return userInfo;
    }


    @PostMapping("/addListUser")
    public String addListUser(@RequestBody @Valid List<CloudUser> userInfoList){

        cloudService.addListUser(userInfoList);
        return "success";
    }


    @PostMapping("/addUserOrder")
    @GlobalTransactional
    public CloudUser addUserOrder(@RequestBody OmsOrder omsOrder){
        CloudUser userInfo = new CloudUser();
        userInfo.setId("1111");
        userInfo.setName("order");
        userInfo.setAge(32);
        int m = cloudService.addUserOrder(omsOrder,userInfo,1);
        return userInfo;
    }

}
