package org.korichat.common.message;

import org.junit.Assert;
import org.junit.Test;
import org.korichat.common.io.ByteArrayUtil;
import org.korichat.messaging.Message;
import org.korichat.messaging.util.MessageDeserializationUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.korichat.common.io.ByteArrayUtil.deserialize;
import static org.korichat.common.io.ByteArrayUtil.serialize;

public class TestMessageDeserialization {

    @Test
    public void testDeserialize() throws IOException, ClassNotFoundException {
        Message<String> message = new Message<>("Hello world", null);
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
        Message<String> message = new Message<>("Hello world", null);
        byte[] serializedBytes = serialize(message);

        // read bytes from input stream as byte[]
        InputStream is = new ByteArrayInputStream(serializedBytes);
        byte[] readInBytes = ByteArrayUtil.readBytesFromStream(is);

        Assert.assertArrayEquals(serializedBytes, readInBytes);

        Message<String> deserializeMessage = deserialize(readInBytes);
        Assert.assertEquals(message, deserializeMessage);
    }
}
