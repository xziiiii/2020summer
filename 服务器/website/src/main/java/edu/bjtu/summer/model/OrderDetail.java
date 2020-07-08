package edu.bjtu.summer.model;

import java.util.Date;

public class OrderDetail {

    private int order_detail_id;
    private String order_number;
    private String order_id;
    private long book_id;
    private int store_id;
    private int mount;
    private double unit_price;
    private double total_price;
    private String post_status;
    private Date deliver_time;
    private String receive_status;
    private String image_url;
    private String book_name;
    private String score;

    public OrderDetail(){}

    public OrderDetail(int order_detail_id, String order_number, String order_id, long book_id,
                       int store_id, int mount, double unit_price, double total_price,
                       String post_status, Date deliver_time, String receive_status, String image_url,
                       String book_name, String score) {
        this.order_detail_id = order_detail_id;
        this.order_number = order_number;
        this.order_id = order_id;
        this.book_id = book_id;
        this.store_id = store_id;
        this.mount = mount;
        this.unit_price = unit_price;
        this.total_price = total_price;
        this.post_status = post_status;
        this.deliver_time = deliver_time;
        this.receive_status = receive_status;
        this.image_url = image_url;
        this.book_name = book_name;
        this.score = score;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getPost_status() {
        return post_status;
    }

    public void setPost_status(String post_status) {
        this.post_status = post_status;
    }

    public Date getDeliver_time() {
        return deliver_time;
    }

    public void setDeliver_time(Date deliver_time) {
        this.deliver_time = deliver_time;
    }

    public String getReceive_status() {
        return receive_status;
    }

    public void setReceive_status(String receive_status) {
        this.receive_status = receive_status;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
