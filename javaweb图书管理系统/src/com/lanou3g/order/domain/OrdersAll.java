package com.lanou3g.order.domain;

public class OrdersAll {
    private String oid;
    private String ordertime;
    private double suntotal;
    private String image;
    private String bname;
    private double price;
    private String author;
    private String COUNT;
    private double sum;

    public OrdersAll() {
    }

    @Override
    public String toString() {
        return "OrdersAll{" +
                "oid='" + oid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", suntotal=" + suntotal +
                ", image='" + image + '\'' +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", COUNT='" + COUNT + '\'' +
                ", sum=" + sum +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getSuntotal() {
        return suntotal;
    }

    public void setSuntotal(double suntotal) {
        this.suntotal = suntotal;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(String COUNT) {
        this.COUNT = COUNT;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
