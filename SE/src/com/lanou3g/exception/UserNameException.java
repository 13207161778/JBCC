package com.lanou3g.exception;

public class UserNameException extends UserName{

    @Override
    public String getMessage() {
        return "账号不和要求,注册失败";
    }
}
