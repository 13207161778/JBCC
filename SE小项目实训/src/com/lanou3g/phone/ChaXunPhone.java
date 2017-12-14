package com.lanou3g.phone;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ChaXunPhone {
    public static void showPhone(String phone) throws IOException {
        URL url = new URL("http://api.k780.com/?app=phone.get&phone="+phone+"&appkey=29836&sign=4fe58a60443a900a251f8b05763d4622&format=json");
        URLConnection com = url.openConnection();

        InputStream inputStream = com.getInputStream();

        byte[] bytes = new byte[1024];

        int len ;
        while ((len=inputStream.read(bytes))!=-1) {
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
        inputStream.close();

    }
}
