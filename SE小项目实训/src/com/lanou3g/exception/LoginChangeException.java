package com.lanou3g.exception;

public class LoginChangeException extends LoginException{
    @Override
    public String getMessage() {
        return "登录次数用完";
    }
}
