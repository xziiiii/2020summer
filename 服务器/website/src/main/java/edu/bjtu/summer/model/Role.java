package edu.bjtu.summer.model;

import java.util.Date;

public class Role {

    private int role_id;
    private String name;
    private String code;
    private String description;
    private Date created;
    private Date updated;

    public Role(){}

    public Role(int role_id, String name, String code, String description, Date created, Date updated) {
        this.role_id = role_id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
