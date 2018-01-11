package com.lanou3g.cart.domain;

import com.lanou3g.book.domain.Book;

public class CartItem {
    private Book book;
    private String count;

    public CartItem() {
    }

    public CartItem(Book book, String count) {
        this.book = book;
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count='" + count + '\'' +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
