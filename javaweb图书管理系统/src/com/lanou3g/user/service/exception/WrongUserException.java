package com.lanou3g.user.service.exception;

public class WrongUserException extends LoginException{
    @Override
    public String getMessage() {
        return "没有该用户";
    }
}
