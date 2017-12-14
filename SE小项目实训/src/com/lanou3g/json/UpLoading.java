package com.lanou3g.json;

import com.lanou3g.login.Register;
import com.lanou3g.playGame.StartGame;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

//上传成绩
public class UpLoading {

    public static void up() throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/insert?username="+ Register.user+"&score="+ StartGame.time);
        URLConnection com = url.openConnection();
        InputStream inputStream = com.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String s = new String(bytes,0,len);
        System.out.println(s);
        inputStream.close();
    }
}
