package com.personal.content_center.controller;

import com.personal.content_center.entity.CloudUser;
import com.personal.content_center.feign.UserInvoke;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/content")
public class ContentController {
     @Autowired
    private UserInvoke userInvoke;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/findUser")
    public CloudUser findUser(String phone){
       return userInvoke.findUser(phone);
    }

    @GetMapping("/getInstances")
    public Map<String,List<ServiceInstance>> getInstances(){
        Map hasMap = new HashMap();
        hasMap.put("1",discoveryClient.getInstances("content-center"));
        hasMap.put("2",discoveryClient.getServices());
        return  hasMap;
    }

    @PostMapping("/sendMsg")
    public void sendMsg(@RequestBody CloudUser cloudUser){
        rocketMQTemplate.convertAndSend("content-topic",cloudUser);
    }


}
