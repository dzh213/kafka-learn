package com.dh.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by donghao on 2019/12/15.
 */
@Component
@Slf4j
public class KafkaProduct {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() {
//        Message msg = MessageBuilder.withPayload("Send Message(payload,headers) Test")
//                .setHeader(KafkaHeaders.MESSAGE_KEY, key)
//                .setHeader(KafkaHeaders.TOPIC, topic)
//                .setHeader(KafkaHeaders.PREFIX,"kafka_")
//                .build();
        /**
         * partition 指定分区
         * key 默认哈希取模
         */
        ListenableFuture<SendResult<String, String>> future =  kafkaTemplate.send("test1",String.valueOf(1),"hello kafka223");
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("发送失败",throwable);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("发送成功,{}",stringStringSendResult);
            }
        });
        log.info("发送");
    }
}
