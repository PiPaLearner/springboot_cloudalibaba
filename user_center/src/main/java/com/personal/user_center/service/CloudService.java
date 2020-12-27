package com.personal.user_center.service;

import com.personal.user_center.entity.OmsOrder;
import com.personal.user_center.entity.user.CloudUser;
import com.personal.user_center.entity.user.CloudUserMapper;
import com.personal.user_center.feign.ContentFeignInvoke;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CloudService {

    @Resource
    private CloudUserMapper cloudUserMapper;

    @Autowired
    private ContentFeignInvoke contentFeignInvoke;


    public int addUser(CloudUser cloudUser ){
        return cloudUserMapper.insert(cloudUser);
    }


    public int addUserOrder(OmsOrder omsOrder,CloudUser cloudUser,int a ){
        int i = cloudUserMapper.insert(cloudUser);
        int m = contentFeignInvoke.addOrder(omsOrder);

        return 1/a;
    }

    public void addListUser(List<CloudUser> cloudUsers){

    }
}
