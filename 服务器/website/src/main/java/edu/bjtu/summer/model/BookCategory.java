package edu.bjtu.summer.model;

import java.util.Date;

public class BookCategory {

    private int cate_id;
    private int parent_id;
    private String name;
    private int status;
    private int sort_order;
    private int is_parent;
    private Date created;
    private Date updated;

    public BookCategory(){}

    public BookCategory(int cate_id, int parent_id, String name, int status,
                        int sort_order, int is_parent, Date created, Date updated) {
        this.cate_id = cate_id;
        this.parent_id = parent_id;
        this.name = name;
        this.status = status;
        this.sort_order = sort_order;
        this.is_parent = is_parent;
        this.created = created;
        this.updated = updated;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public int getIs_parent() {
        return is_parent;
    }

    public void setIs_parent(int is_parent) {
        this.is_parent = is_parent;
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
