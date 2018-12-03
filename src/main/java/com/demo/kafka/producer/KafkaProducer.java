package com.demo.kafka.producer;

import com.demo.kafka.stubs.MessagePublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    KafkaTemplate<String,MessagePublish> kafkaTemplate;

    public void sendMessage(final String topicName,final MessagePublish messagePublish){
        logger.info("producer sending message...='{}'", messagePublish);
        kafkaTemplate.send(topicName,messagePublish);
        logger.info("message send successfully ='{}'",messagePublish);
    }
}
