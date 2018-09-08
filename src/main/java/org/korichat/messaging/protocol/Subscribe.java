package org.korichat.messaging.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Subscribe implements Serializable {
    private String topic;
}
