package com.demo.kafka.scheduler;

import com.demo.kafka.producer.KafkaProducer;
import com.demo.kafka.stubs.MessagePublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaScheduler {
    private final static Logger logger = LoggerFactory.getLogger(KafkaScheduler.class);

    @Autowired
    KafkaProducer kafkaProducer;


    @Scheduled(fixedRate = 10000)
    public void sendMessageToKafka() {
        MessagePublish messagePublish = new MessagePublish();
        messagePublish.setMsgId(String.valueOf(System.currentTimeMillis()));
        messagePublish.setMsgPayload("hello "+System.currentTimeMillis());
        logger.info("scheduler started message sending to kafka..");
        kafkaProducer.sendMessage("test",messagePublish);

    }

}
