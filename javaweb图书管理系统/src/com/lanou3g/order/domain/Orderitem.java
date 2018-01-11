package com.lanou3g.order.domain;

public class Orderitem {
    private String iid;
    private String COUNT;
    private String subtotal;
    private String oid;
    private String bid;

    public Orderitem() {
    }

    @Override
    public String toString() {
        return "Orderitem{" +
                "iid='" + iid + '\'' +
                ", COUNT='" + COUNT + '\'' +
                ", subtotal='" + subtotal + '\'' +
                ", oid='" + oid + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(String COUNT) {
        this.COUNT = COUNT;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
