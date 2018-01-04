package bean;

public class Book {
    private String bid;
    private String bname;
    private String autor;
    private String pay;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", autor='" + autor + '\'' +
                ", pay='" + pay + '\'' +
                '}';
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
