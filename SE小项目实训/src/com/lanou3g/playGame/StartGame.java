package com.lanou3g.playGame;

import com.lanou3g.json.First;
import com.lanou3g.json.UpLoading;

import java.io.IOException;
import java.util.Scanner;

public class StartGame {
    static char[]  chars;
   public static long time;
    public static void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择游戏模式:1:困难(随机30个字符)   2:适中(随机20个字符)    3:简单(随机10个字符)");
        String s = scanner.nextLine();
       switch (s){
           case "1":

             random(30);
               break;
           case "2":
               random(20);
               break;
           case "3":
               random(10);
               break;
               default:
                   break;
       }
    }
    public static void random(int lenght) throws IOException {

        for (int i = 3; i >0 ;i-- ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("游戏开始倒计时"+i+"秒");

        }
           chars = new char[lenght];

        switch (lenght){
            case 30:
        for (int i = 0; i <chars.length ; i++) {
           char  c =  (char)((Math.random() * (123 - 33) + 33) + 1);
            chars[i]=c;
        }
        System.out.println(chars);
        break;
            case 20:
                for (int i = 0; i <chars.length-2 ; i++) {
                    char  c =  (char)((Math.random() * (91 - 65) + 65) + 1);
                    char  c1 =  (char)((Math.random() * (123 - 97) + 65) + 1);
                    char  c2 =  (char)((Math.random() * (48 - 57) + 57) + 1);
                    chars[i]=c;
                    chars[i+1]=c1;
                    chars[i+2]=c2;
                }
                System.out.println(chars);
                break;
            case 10:
                for (int i = 0; i <chars.length-1 ; i++) {
                    char  c =  (char)((Math.random() * (91 - 65) + 65) + 1);
                    char  c1 =  (char)((Math.random() * (123 - 97) + 97) + 1);
                    chars[i]=c;
                    chars[i+1]=c1;
                }
                System.out.println(chars);
                break;
                default:
                    break;
        }
        time();

    }
    public static void time() throws IOException {
        Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();
        String s = scanner.nextLine();
        String s1 = String.valueOf(chars);
        if(s.equals(s1)){
            long end = System.currentTimeMillis();
            time = end-start;
            System.out.println("花费时间:"+time+"ms");
        }else {
            System.out.println("输入错误请重新输入");
            time();
        }
        UpLoading.up();
        First.first();
        System.exit(0);
    }
}
