package com.lanou3g.exception;

public class UserRepetition extends UserName{
    @Override
    public String getMessage() {
        return "账号重复,注册失败";
    }
}
