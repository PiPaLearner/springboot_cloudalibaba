package com.personal.content_center.feign;


import com.personal.content_center.entity.CloudUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-center")
public interface UserInvoke {

    @GetMapping("/user/findUser")
    CloudUser findUser(@RequestParam String phone);

}
