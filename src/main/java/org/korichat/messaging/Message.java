package org.korichat.messaging;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class Message<T> implements Serializable {
    private final String identifier;

    private T payload;
    private String topic;
    private Class payloadType;

    private Map<String, String> headers;

    public Message(T payload, String topic) {
        this(UUID.randomUUID().toString(), payload, topic, new HashMap<String, String>());
    }

    public Message(String identifier, T payload, String topic, Map<String, String> headers) {
        this.identifier = identifier;
        this.payload = payload;
        this.topic = topic;
        this.headers = headers;
        this.payloadType = this.payload.getClass();
    }

    public void addHeader(String key, String value) {
        if(this.headers != null) {
            this.headers.put(key, value);
        }
    }
}
