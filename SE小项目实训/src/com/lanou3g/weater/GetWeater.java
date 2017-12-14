package com.lanou3g.weater;

import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetWeater {
    public static void weater(String city) throws IOException {
        URL url = new URL("http://www.sojson.com/open/api/weather/json.shtml?city="+city);
        InputStream inputStream1 = url.openStream();
        byte[] bytes = new byte[1024];
        int len ;
        while ((len = inputStream1.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
    }

}
