package com.lanou3g.login;

import com.lanou3g.exception.LoginChangeException;
import com.lanou3g.exception.UserNameException;
import com.lanou3g.exception.UserRepetition;
import org.dom4j.DocumentException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException, UserNameException, UserRepetition, LoginChangeException {
        Register.login();




    }
}
