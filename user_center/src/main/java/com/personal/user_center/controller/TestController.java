package com.personal.user_center.controller;

import com.personal.user_center.entity.OmsOrder;
import com.personal.user_center.feign.ContentFeignInvoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ContentFeignInvoke contentFeignInvoke;

    @PostMapping("/addContentorder")
    public int addContentorder(@RequestBody OmsOrder omsOrder){
        return contentFeignInvoke.addOrder(omsOrder);
    }

    @PostMapping("/getInstances")
    public Map<String, List<ServiceInstance>> getInstances(){
        return contentFeignInvoke.getInstances();
    }

    @GetMapping("/getMapInfo")
    public Map<String,String> getMapInfo(){
        return contentFeignInvoke.getMapInfo();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        for(int i=0;i<2;i++){
            new Thread(()->{
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-=====start");
                countDownLatch.countDown();
                System.out.println("-------end");
            }).start();
        }
        System.out.println("cowntdown阻塞");
        countDownLatch.await();
        System.out.println("cowntdown成功");
    }
}
