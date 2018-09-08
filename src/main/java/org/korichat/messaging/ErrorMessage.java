package org.korichat.messaging;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorMessage implements Serializable {
    private Throwable error;
}
