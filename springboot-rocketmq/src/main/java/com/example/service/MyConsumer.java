package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RocketMQMessageListener(topic = "TopicTest", consumerGroup = "my-consumer_TopicTest")
public class MyConsumer implements RocketMQListener<String> {
    public void onMessage(String message) {
        log.info(Thread.currentThread().getName() + " : " + message);
    }
}
