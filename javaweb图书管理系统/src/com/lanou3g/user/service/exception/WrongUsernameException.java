package com.lanou3g.user.service.exception;

public class WrongUsernameException extends LoginException{
    @Override
    public String getMessage() {
        return "用户名不正确";
    }
}
