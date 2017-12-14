package com.lanou3g.login;

import com.lanou3g.json.ChaXun;
import com.lanou3g.phone.ChaXunPhone;
import com.lanou3g.playGame.StartGame;
import com.lanou3g.weater.GetWeater;

import java.io.IOException;
import java.util.Scanner;

public class FirstPage {

    public static void show() throws IOException {
        System.out.println("1:查询天气      2:查询手机号归属地      3:手速游戏       4:查询手速游戏前十排名");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        switch (s){
            case "1":
                System.out.println("请输入你要查询的天气");
                String w = scanner.nextLine();
                GetWeater.weater(w);
                break;
            case "2":
                System.out.println("请输入你要查询的号码");
                String p = scanner.nextLine();
                ChaXunPhone.showPhone(p);
                break;
            case "3":
                StartGame.start();
                break;
            case "4":
                ChaXun.show();
                break;
                default:
                    break;
        }
    }
}
