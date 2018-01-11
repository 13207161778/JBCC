package com.lanou3g.user.service.exception;

public class CokeyException extends RegisterException{

    @Override
    public String getMessage() {
        return "你还没有激活验证码";
    }
}
