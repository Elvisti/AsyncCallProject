package com.asynccall.supermarket.kafka.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class SendMessage {
    private static final Logger LOGGER = LogManager.getLogger(SendMessage.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg, String topic) {
        LOGGER.info("Sending message on kafka topic: {}", topic);
        kafkaTemplate.send(topic, msg);
    }

//
//    CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
//     future.whenComplete((result, ex) -> {
//        if (ex == null) {
//            System.out.println("Sent message=[" + message +
//                    "] with offset=[" + result.getRecordMetadata().offset() + "]");
//        } else {
//            System.out.println("Unable to send message=[" +
//                    message + "] due to : " + ex.getMessage());
//        }
//    });
}
