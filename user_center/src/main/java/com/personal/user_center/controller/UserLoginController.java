package com.personal.user_center.controller;


import com.personal.user_center.entity.OmsOrder;
import com.personal.user_center.entity.user.CloudUser;
import com.personal.user_center.feign.ContentFeignInvoke;
import com.personal.user_center.service.CloudService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CloudUser addUser(@RequestBody CloudUser userInfo){
        userInfo.setName("lisi");
        userInfo.setAge(32);
        int i = cloudService.addUser(userInfo);
        return userInfo;
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
