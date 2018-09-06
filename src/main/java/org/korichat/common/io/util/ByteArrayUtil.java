package org.korichat.common.io.util;

import java.io.*;

public class ByteArrayUtil {

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }
    public static <T> T deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return (T) is.readObject();
    }

    public static byte[] streamInBytes(InputStream is) throws IOException {
        ByteArrayOutputStream byteArrayCollector = new ByteArrayOutputStream();
        int readIn;
        while ((readIn = is.read()) != -1) {
            byteArrayCollector.write(readIn);
        }
        byteArrayCollector.flush();
        return byteArrayCollector.toByteArray();
    }
}
