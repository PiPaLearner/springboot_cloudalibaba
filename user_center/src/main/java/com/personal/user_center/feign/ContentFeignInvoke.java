package com.personal.user_center.feign;

import com.personal.user_center.entity.OmsOrder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Map;

@FeignClient("content-center")
public interface ContentFeignInvoke {

    @GetMapping("/content/getInstances")
    Map<String, List<ServiceInstance>> getInstances();

    @PostMapping("/content/addOrder")
    int addOrder(@RequestBody OmsOrder omsOrder);

    @GetMapping("/content/getMapInfo")
    Map<String,String> getMapInfo();
}
