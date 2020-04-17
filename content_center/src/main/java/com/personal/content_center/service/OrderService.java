package com.personal.content_center.service;

import com.personal.content_center.entity.content.OmsOrder;
import com.personal.content_center.entity.content.OmsOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private OmsOrderMapper omsOrderMapper;

    public int addOrder(OmsOrder omsOrder){
       return omsOrderMapper.insertSelective(omsOrder);
    }

}
