package com.lanou3g.login;

import com.lanou3g.exception.LoginChangeException;
import com.lanou3g.exception.UserNameException;
import com.lanou3g.exception.UserRepetition;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class XMLFile {

    public static void ReadXML() throws IOException, DocumentException, UserNameException, UserRepetition, LoginChangeException {
        Document document = DocumentHelper.createDocument();
        Element element = document.addElement("users");
        element.addText("用户信息");
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/user.xml"),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
        System.out.println("开始注册");
        start();
        adduser();
    }
    public static void start() throws DocumentException, IOException, UserNameException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入注册昵称");
        String nickName = scanner.nextLine();
        System.out.println("请输入注册用户名");
        String userName = scanner.nextLine();
        System.out.println("请输入注册用户名密码");
        String userPasswd = scanner.nextLine();
        //匹配电话号码,开头必须为1  昵称必须是英文长度为1-10;
        if(Pattern.matches("[1]\\d{10}",userName)||Pattern.matches("^[a-z_\\d]+(?:\\.[a-z_\\d]+)*@qq\\.com$",userName) && Pattern.matches("[A-Z a-z 0-9]{7,14}",userPasswd)&& Pattern.matches("[a-z A-z]{1,10}",nickName)) {
            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(new File("src/user.xml"));
            Element rootElement = read.getRootElement();
            Element user = rootElement.addElement("user");
            user.addAttribute("userName", userName);
            Element userPasswd1 = user.addElement("userPsswd");
            userPasswd1.addText(userPasswd);
            Element element = user.addElement("nickName");
            element.addText(nickName);
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            outputFormat.setEncoding("UTF-8");
            XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/user.xml"), outputFormat);
            xmlWriter.write(read);
            xmlWriter.close();

        }else {
            throw new UserNameException();
        }

    }
    private static void adduser() throws DocumentException, UserRepetition, IOException, UserNameException, LoginChangeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("是否继续?   1:继续      2;结束");
        if(scanner.nextLine().equals("1")){

            System.out.println("请输入注册昵称");
            String nickName = scanner.nextLine();
            System.out.println("请输入注册用户名");
            String userName = scanner.nextLine();
            System.out.println("请输入注册用户名密码");
            String userPasswd = scanner.nextLine();

            if(Pattern.matches("[1]\\d{10}",userName)||Pattern.matches("^[a-z_\\d]+(?:\\.[a-z_\\d]+)*@qq\\.com$",userName) && Pattern.matches("[A-Z a-z 0-9]{7,14}",userPasswd)&& Pattern.matches("[a-z A-z]{1,10}",nickName)) {
                SAXReader saxReader = new SAXReader();
                Document read = saxReader.read(new File("src/user.xml"));
                Element rootElement = read.getRootElement();
                List<Element> list = rootElement.elements();
                for(int i = 0;i<list.size();i++){
                    Element element = list.get(i);
                    Attribute phone = element.attribute("userName");
                    if(phone.getValue().equals(userName)){
                        throw new UserRepetition();
                    }
                }
                    Element element3 = rootElement.addElement("user");
                    element3.addAttribute("userName",userName);
                    Element element1 = element3.addElement("userPsswd");
                    element1.addText(userPasswd);
                    Element element2 = element3.addElement("nickName");
                    element2.addText(nickName);

                OutputFormat outputFormat = OutputFormat.createPrettyPrint();
                outputFormat.setEncoding("UTF-8");
                XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/user.xml"), outputFormat);
                xmlWriter.write(read);
                xmlWriter.close();
                adduser();
            }

            if (scanner.nextLine().equals("2")){
                Register.login();
            }
        }
    }
}
