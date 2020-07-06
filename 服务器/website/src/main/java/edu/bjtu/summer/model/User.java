package edu.bjtu.summer.model;

import java.util.Date;

public class User {

    private int user_id;
    private String username;
    private String nickname;
    private String password;
    private String gender;
    private String email;
    private String phone;
    private String zip_code;
    private String location;
    private int age;
    private String country;
    private String detail_address;
    private String identity;
    private String active;
    private String code;
    private Date updated;
    private Date created;

    public User(){}

    public User(int user_id, String username, String nickname, String gender, String email,
                String phone, String zip_code, String location, int age, String country,
                String detail_address, String identity, String active, String code,
                Date updated, Date created) {
        this.user_id = user_id;
        this.username = username;
        this.nickname = nickname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.zip_code = zip_code;
        this.location = location;
        this.age = age;
        this.country = country;
        this.detail_address = detail_address;
        this.identity = identity;
        this.active = active;
        this.code = code;
        this.updated = updated;
        this.created = created;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
