package org.korichat.common.message;

import org.korichat.model.message.Message;
import org.korichat.model.message.MessageException;

public class MessageDeserializationUtil {
    public static <T> Message<T> deserialize(Message message, Class<T> klass) {
        if(message.getPayloadType() != null && message.getPayloadType() == klass) {
            T payload = (T) message.getPayload();

            return new Message<>(message.getIdentifier(), payload, message.getHeaders());
        }
        throw new MessageException(String.format("Message payload type (%s) is not what you expected!", message.getPayloadType()));
    }
}
