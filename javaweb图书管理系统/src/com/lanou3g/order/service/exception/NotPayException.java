package com.lanou3g.order.service.exception;

public class NotPayException extends Exception{
    @Override
    public String getMessage() {
        return "您还没有支付";
    }
}
