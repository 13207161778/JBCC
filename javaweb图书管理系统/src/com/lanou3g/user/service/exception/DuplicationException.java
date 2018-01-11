package com.lanou3g.user.service.exception;

public class DuplicationException extends RegisterException{

    @Override
    public String getMessage() {
        return "用户名重复";
    }
}
