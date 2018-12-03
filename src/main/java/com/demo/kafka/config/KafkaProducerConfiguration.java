package com.demo.kafka.config;


import com.demo.kafka.stubs.MessagePublish;
import com.demo.kafka.stubs.MessagePublishDeserializer;
import com.demo.kafka.stubs.MessagePublishSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {


    @Bean
    public Map<String, Object> producerConfig(){
        Map<String ,Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,MessagePublishSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String, MessagePublish> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, MessagePublish> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
