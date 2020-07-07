package edu.bjtu.summer.model;

import java.util.Date;

public class Store {

    private int store_id;
    private int store_manager_id;
    private String store_phone_num;
    private String store_telephone;
    private String store_name;
    private String store_position;
    private Date created;
    private Date updated;

    public Store(){}

    public Store(int store_id, int store_manager_id, String store_phone_num,
                 String store_telephone, String store_name, String store_position,
                 Date created, Date updated) {
        this.store_id = store_id;
        this.store_manager_id = store_manager_id;
        this.store_phone_num = store_phone_num;
        this.store_telephone = store_telephone;
        this.store_name = store_name;
        this.store_position = store_position;
        this.created = created;
        this.updated = updated;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getStore_manager_id() {
        return store_manager_id;
    }

    public void setStore_manager_id(int store_manager_id) {
        this.store_manager_id = store_manager_id;
    }

    public String getStore_phone_num() {
        return store_phone_num;
    }

    public void setStore_phone_num(String store_phone_num) {
        this.store_phone_num = store_phone_num;
    }

    public String getStore_telephone() {
        return store_telephone;
    }

    public void setStore_telephone(String store_telephone) {
        this.store_telephone = store_telephone;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_position() {
        return store_position;
    }

    public void setStore_position(String store_position) {
        this.store_position = store_position;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
