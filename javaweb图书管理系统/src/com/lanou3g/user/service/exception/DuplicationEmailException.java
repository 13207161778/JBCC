package com.lanou3g.user.service.exception;

public class DuplicationEmailException extends RegisterException{
    @Override
    public String getMessage() {
        return "邮箱重复";
    }
}
