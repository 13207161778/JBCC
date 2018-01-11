package com.lanou3g.order.domain;

import com.lanou3g.cart.domain.CartItem;

import java.util.List;

public class OrderPage {
    private String orderId;
    private String orderTime;
    private double  ordersum;
    private List<CartItem> lists;
    private String address;

    public OrderPage() {
    }

    @Override
    public String toString() {
        return "OrderPage{" +
                "orderId='" + orderId + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", ordersum='" + ordersum + '\'' +
                ", lists=" + lists +
                ", address='" + address + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(double ordersum) {
        this.ordersum = ordersum;
    }

    public List<CartItem> getLists() {
        return lists;
    }

    public void setLists(List<CartItem> lists) {
        this.lists = lists;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderPage(String orderId, String orderTime, double ordersum, List<CartItem> lists, String address) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.ordersum = ordersum;
        this.lists = lists;
        this.address = address;
    }
}
