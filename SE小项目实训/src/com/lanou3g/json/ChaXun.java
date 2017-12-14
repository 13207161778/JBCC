package com.lanou3g.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ChaXun {

    public static void show() throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/ten");
        URLConnection com = url.openConnection();
        InputStream inputStream = com.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String s = new String(bytes,0,len);
        System.out.println(s);
        inputStream.close();
        System.exit(0);
    }
}
