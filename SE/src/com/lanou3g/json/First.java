package com.lanou3g.json;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


import java.io.*;

import java.net.URL;
import java.net.URLConnection;

public class First {

    public static void first() throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/first");
        URLConnection com = url.openConnection();
        InputStream inputStream = com.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String s = new String(bytes,0,len);
        XStream xStream = new XStream(new DomDriver());
        Object o = xStream.fromXML(s);
        xStream.alias("User",User.class);
        User user = (User)o;
        System.out.println("该模式第一名:"+user.getNickName()+"  "+"花费时间:"+user.getScore());

    }
}
