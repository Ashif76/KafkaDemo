package com.demo.kafka.stubs;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MessagePublishSerializer implements Serializer<MessagePublish> {



  @Override
  public void configure(final Map map, final boolean b) {

  }

  @Override
  public byte[] serialize(final String s, final MessagePublish arg1) {
        byte[] retVal = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      retVal = objectMapper.writeValueAsString(arg1).getBytes();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return retVal;
  }

  @Override public void close() {

  }

}