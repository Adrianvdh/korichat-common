package org.korichat.common.internal;

import lombok.Data;

import java.util.UUID;

@Data
public class Initialize {
    private String identity;

    public Initialize() {
        this.identity = UUID.randomUUID().toString();
    }
}
