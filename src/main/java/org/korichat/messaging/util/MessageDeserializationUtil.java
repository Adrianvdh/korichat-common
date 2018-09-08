package org.korichat.messaging.util;

import org.korichat.messaging.Message;
import org.korichat.messaging.MessageException;

public class MessageDeserializationUtil {
    public static <T> Message<T> deserialize(Message message, Class<T> klass) {
        if(message.getPayloadType() != null && message.getPayloadType() == klass) {
            T payload = (T) message.getPayload();

            return new Message<>(message.getIdentifier(), payload, message.getTopic(), message.getHeaders());
        }
        throw new MessageException(String.format("Message payload type (%s) is not what you expected!", message.getPayloadType()));
    }
}
