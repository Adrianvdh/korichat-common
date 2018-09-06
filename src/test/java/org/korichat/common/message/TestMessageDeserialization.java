package org.korichat.common.message;

import org.junit.Assert;
import org.junit.Test;
import org.korichat.common.io.util.ByteArrayUtil;
import org.korichat.model.message.Message;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.korichat.common.io.util.ByteArrayUtil.deserialize;
import static org.korichat.common.io.util.ByteArrayUtil.serialize;

public class TestMessageDeserialization {

    @Test
    public void testDeserialize() throws IOException, ClassNotFoundException {
        Message<String> message = new Message<>("Hello world");
        byte[] objectBytes = serialize(message);

        Message objectMessage = ByteArrayUtil.deserialize(objectBytes);

        if (objectMessage.getPayloadType() == String.class) {
            Message<String> deserializeMessage = MessageDeserializationUtil.deserialize(objectMessage, String.class);

            Assert.assertEquals(message, deserializeMessage);
        } else {
            Assert.fail("Message payload type is incorrect!!!");
        }
    }

    @Test
    public void testReadByteDataOverStream() throws IOException, ClassNotFoundException {
        // serialize object into byte[]
        Message<String> message = new Message<>("Hello world");
        byte[] serializedBytes = serialize(message);

        // read bytes from input stream as byte[]
        InputStream is = new ByteArrayInputStream(serializedBytes);
        byte[] readInBytes = ByteArrayUtil.streamInBytes(is);

        Message<String> deserializeMessage = deserialize(readInBytes);

        Assert.assertEquals(message, deserializeMessage);
    }
}
