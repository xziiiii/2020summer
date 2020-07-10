package edu.bjtu.summer.model;

public class ShoppingCarDetail {

    private int user_id;
    private int book_id;
    private int amount;
    private double unit_price;

    public ShoppingCarDetail(){}

    public ShoppingCarDetail(int user_id, int book_id, int amount, double unit_price) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.amount = amount;
        this.unit_price = unit_price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
}
