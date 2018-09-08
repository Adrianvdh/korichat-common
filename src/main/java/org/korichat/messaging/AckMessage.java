package org.korichat.messaging;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class AckMessage implements Serializable {
    private final String identifier;
    private final Long timestamp;
    private final Map<String, String> meta = new HashMap<>();

    public AckMessage(String identifier) {
        this.identifier = identifier;
        this.timestamp = System.currentTimeMillis();
    }

    public void addMetaData(String property, String value) {
        meta.put(property, value);
    }
}
