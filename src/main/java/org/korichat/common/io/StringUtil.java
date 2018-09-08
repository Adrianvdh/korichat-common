package org.korichat.common.io;

import java.io.BufferedReader;
import java.io.IOException;

public class StringUtil {

    public static String waitForRequest(BufferedReader reader) {
        StringBuilder requestBuilder = new StringBuilder();
        try {
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                requestBuilder.append(inputLine);
                if (!reader.ready()) {
                    break;
                }
                requestBuilder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestBuilder.toString();
    }
}
