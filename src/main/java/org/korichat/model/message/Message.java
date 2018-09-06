package org.korichat.model.message;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class Message<T> implements Serializable {
    private final String identifier;
    private Class payloadType;
    private T payload;
    private Map<String, String> headers;

    public Message(T payload) {
        this(UUID.randomUUID().toString(), payload, new HashMap<String, String>());
    }

    public Message(T payload, Map<String, String> headers) {
        this(UUID.randomUUID().toString(), payload, headers);
    }

    public Message(String identifier, T payload, Map<String, String> headers) {
        this.identifier = identifier;
        this.payload = payload;
        this.headers = headers;
        this.payloadType = this.payload.getClass();
    }

    public void addHeader(String key, String value) {
        if(this.headers != null) {
            this.headers.put(key, value);
        }
    }
}
