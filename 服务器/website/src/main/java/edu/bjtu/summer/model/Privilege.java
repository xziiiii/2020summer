package edu.bjtu.summer.model;

import java.util.Date;

public class Privilege {

    private int priv_id;
    private String name;
    private String code;
    private String url;
    private int parent_id;
    private Date created;
    private Date updated;
    private int is_parent;

    public Privilege(){}

    public Privilege(int priv_id, String name, String code, String url,
                     int parent_id, Date created, Date updated, int is_parent) {
        this.priv_id = priv_id;
        this.name = name;
        this.code = code;
        this.url = url;
        this.parent_id = parent_id;
        this.created = created;
        this.updated = updated;
        this.is_parent = is_parent;
    }

    public int getPriv_id() {
        return priv_id;
    }

    public void setPriv_id(int priv_id) {
        this.priv_id = priv_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
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

    public int getIs_parent() {
        return is_parent;
    }

    public void setIs_parent(int is_parent) {
        this.is_parent = is_parent;
    }
}
