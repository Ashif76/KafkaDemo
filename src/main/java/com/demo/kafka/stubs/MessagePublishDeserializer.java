package com.demo.kafka.stubs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class MessagePublishDeserializer implements Deserializer<MessagePublish> {
    @Override
    public void configure(final Map<String, ?> map, final boolean b) {

    }

    @Override
    public MessagePublish deserialize(final String s, final byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        MessagePublish messagePublish = null;
        try {
            messagePublish = mapper.readValue(bytes, MessagePublish.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return messagePublish;
    }

    @Override
    public void close() {

    }
}
