package com.lanou3g.user.service.exception;

public class NotLoginException extends LoginException{
    @Override
    public String getMessage() {
        return "您还没有登录";
    }
}
