package com.demo.kafka.stubs;

public class MessagePublish {
    private String msgId;
    private String msgPayload;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(final String msgId) {
        this.msgId = msgId;
    }

    public String getMsgPayload() {
        return msgPayload;
    }

    public void setMsgPayload(final String msgPayload) {
        this.msgPayload = msgPayload;
    }

    @Override
    public String toString() {
        return "MessagePublish{" +
                "msgId='" + msgId + '\'' +
                ", msgPayload='" + msgPayload + '\'' +
                '}';
    }

}
