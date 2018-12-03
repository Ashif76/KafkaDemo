package com.demo.kafka.consumer;

import com.demo.kafka.stubs.MessagePublish;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    KafkaTemplate<String,MessagePublish> kafkaTemplate;
    @KafkaListener(topics = "test", containerFactory = "kafkaListenerContainerFactory")
    public void consumeMessage(@Payload MessagePublish message){
        logger.info("kafka message received ='{}'", message);

    }
}
