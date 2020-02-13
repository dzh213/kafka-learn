package com.dh.kafka.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by donghao on 2019/12/15.
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "test1")
    public void processMessage(ConsumerRecord<Integer, String> record, Acknowledgment acknowledgment) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        try {
            if (kafkaMessage.isPresent()) {

                Object message = kafkaMessage.get();

                log.info("----------------- record =" + record);
                log.info("------------------ message =" + message);
                log.info("processMessage, topic = {}, msg = {}", record.topic(), record.value());

                if ("hello kafka222".equals(message)) {
                    int a = 1/0;
                }
            }

            acknowledgment.acknowledge();
        }catch (Exception e) {
            log.error("消息监听异常",e);
        }

        // do something ...

        log.info("kafka processMessage end");
    }
}
