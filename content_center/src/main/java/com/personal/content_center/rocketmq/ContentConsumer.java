package com.personal.content_center.rocketmq;

import com.personal.content_center.entity.CloudUser;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@RocketMQMessageListener(consumerGroup = "content_group", topic = "content-topic")
@Service
public class ContentConsumer implements RocketMQListener<CloudUser> {


    @Override
    public void onMessage(CloudUser message) {
        System.out.println(message.toString());
    }
}
