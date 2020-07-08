package edu.bjtu.summer.model;

import java.util.Date;

public class Order {

    private String order_id;
    private int user_id;
    private String payment;
    private int payment_type;
    private int status;
    private String post_fee;
    private Date create_time;
    private Date update_time;
    private int order_mount;
    private Date payment_time;
    private Date end_time;
    private String shipping_name;
    private String shipping_code;
    private String buyer_message;
    private int buyer_rate;

    public Order(){}

    public Order(String order_id, int user_id, String payment, int payment_type, int status,
                 String post_fee, Date create_time, Date update_time, int order_mount,
                 Date payment_time, Date end_time, String shipping_name, String shipping_code,
                 String buyer_message, int buyer_rate) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.payment = payment;
        this.payment_type = payment_type;
        this.status = status;
        this.post_fee = post_fee;
        this.create_time = create_time;
        this.update_time = update_time;
        this.order_mount = order_mount;
        this.payment_time = payment_time;
        this.end_time = end_time;
        this.shipping_name = shipping_name;
        this.shipping_code = shipping_code;
        this.buyer_message = buyer_message;
        this.buyer_rate = buyer_rate;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(int payment_type) {
        this.payment_type = payment_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPost_fee() {
        return post_fee;
    }

    public void setPost_fee(String post_fee) {
        this.post_fee = post_fee;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getOrder_mount() {
        return order_mount;
    }

    public void setOrder_mount(int order_mount) {
        this.order_mount = order_mount;
    }

    public Date getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(Date payment_time) {
        this.payment_time = payment_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getShipping_name() {
        return shipping_name;
    }

    public void setShipping_name(String shipping_name) {
        this.shipping_name = shipping_name;
    }

    public String getShipping_code() {
        return shipping_code;
    }

    public void setShipping_code(String shipping_code) {
        this.shipping_code = shipping_code;
    }

    public String getBuyer_message() {
        return buyer_message;
    }

    public void setBuyer_message(String buyer_message) {
        this.buyer_message = buyer_message;
    }

    public int getBuyer_rate() {
        return buyer_rate;
    }

    public void setBuyer_rate(int buyer_rate) {
        this.buyer_rate = buyer_rate;
    }
}
