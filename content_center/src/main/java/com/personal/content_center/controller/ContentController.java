package com.personal.content_center.controller;

import com.personal.content_center.entity.CloudUser;
import com.personal.content_center.feign.UserInvoke;
import com.personal.content_center.service.OrderService;
import com.personal.content_center.entity.content.OmsOrder;
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
    @Autowired
    private OrderService orderService;

    /**
     * feign客户端进行RPC微服务组件件调用
     * */
    @GetMapping("/findUser")
    public CloudUser findUser(String phone){
       return userInvoke.findUser(phone);
    }

    /**
     * nacos api接口获取服务组件信息
     * */
    @GetMapping("/getInstances")
    public Map<String,List<ServiceInstance>> getInstances(){
        Map hasMap = new HashMap();
        hasMap.put("1",discoveryClient.getInstances("content-center"));
        hasMap.put("2",discoveryClient.getServices());
        return  hasMap;
    }

    /**
     * rocketMq消息中间件消息发送
     * */
    @PostMapping("/sendMsg")
    public void sendMsg(@RequestBody CloudUser cloudUser){
        rocketMQTemplate.convertAndSend("content-topic",cloudUser);
    }

    /**
     * seata分布式事务组件集成测试
     * */
    @PostMapping("/addOrder")
    public int addOrder(@RequestBody OmsOrder omsOrder){
        System.out.println("11111=======1111=====seata");
        return  orderService.addOrder(omsOrder);
    }

    /**
     * feign测试
     * */
    @GetMapping("/getMapInfo")
    public Map<String,String> getMapInfo(){
        Map hasMap = new HashMap();
        hasMap.put("1","1");
        hasMap.put("2","2");
        return  hasMap;
    }



}
