package com.lanou3g.login;


import com.lanou3g.exception.LoginChangeException;
import com.lanou3g.exception.UserNameException;
import com.lanou3g.exception.UserRepetition;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Register {
    //注册
    static int  temp = 3;
   public static String user="";
    public static void login() throws UserRepetition, UserNameException, DocumentException, IOException, LoginChangeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1:注册      2:登录");
        String s = scanner.nextLine();
        if(s.equals("1")){
            XMLFile.ReadXML();
        }
        if(s.equals("2")){
            
            System.out.println("请输入账号");
            String userName = scanner.nextLine();
            System.out.println("请输入密码");
            String userPasswd = scanner.nextLine();

            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(new File("src/user.xml"));
            Element rootElement = read.getRootElement();
            List<Element> list = rootElement.elements();
            for(int i=0;i<list.size();i++){
                Element element = list.get(i);
                Attribute phone = element.attribute("userName");
                Element userPsswd = element.element("userPsswd");
                if(userName.equals(phone.getValue()) && userPasswd.equals(userPsswd.getText())){
                    user = phone.getValue();
                    FirstPage.show();
                    }
            }
        }
    }
}
