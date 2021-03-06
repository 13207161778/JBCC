package com.lanou3g.util;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class JavaMailUtil {
    private String sendAddr = "191506389@qq.com";//这是发送方的邮箱
    //这个不是密码,是开启163邮箱第三方登录时候设置的授权码
    //如果不开启,那么是无法第三方登录163邮箱账号的
    private String pass = "bgbejrmmwoosbihj";
    public void t1(String string) throws MessagingException {
         String receiveAddr = string;
//        String  receiveAddr = string;//接收方的邮箱
        Properties prop = new Properties();
        //设置服务器主机名
        prop.setProperty("mail.smtp.host", "smtp.qq.com");
        prop.setProperty("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.port", "587");
//		prop.put("mail.transport.protocol", "smtp");

        //我们要登录一个账号,来给别人发邮件
        //现在先构建一个邮件账号，需要用邮件地址和密码
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendAddr,pass);

            }
        };

        //与服务器连接,这时候就连上了163.com的服务器
        //实际上就是用java代码,登录了自己的163邮箱
        Session session = Session.getInstance(prop,auth);


        //创建一个邮件对象
        //这就是登录了邮箱之后,点击了发邮件,进入编辑邮件的窗口
        MimeMessage msg = new MimeMessage(session);

        //设置发件人
        msg.setFrom(new InternetAddress(sendAddr));

        //设置收件人
        msg.setRecipients(Message.RecipientType.TO,receiveAddr);

        //设置抄送
//		msg.setRecipients(Message.RecipientType.CC,"抄送人@163.com");

        //设置密送
        //一封邮件发给了a,b,c三个人,a是可以知道这封邮件也发给了b,c的
        //如果设置了密送给d,那么a,b,c是不知道这封邮件也发给了d的
//		msg.setRecipients(Message.RecipientType.BCC,"偷偷的发@163.com");

        //添加主题
        msg.setSubject("这是来自王先生的邮件");

        //添加内容,第二个参数表示这是html的内容
        msg.setContent("<a href="+"http://localhost:8080/user?method=active"+">点击激活验证码</a>","text/html;charset=utf-8");

        Transport.send(msg);
    }

}
