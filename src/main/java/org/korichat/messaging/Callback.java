package org.korichat.messaging;

public interface Callback {

    void onAck(AckMessage ackMessage);
    void onError(Throwable throwable);
}
