package com.zydata.entity.master;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ManagerEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String token;
    private String phone;
    private String email;
    private Integer actor;
    private String charnam; //等级名称
    private Date create_time;
    private Date modify_time;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public String getCharnam() {
        return charnam;
    }

    public void setCharnam(String charnam) {
        this.charnam = charnam;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getModify_time() {
        return modify_time;
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    @Override
    public String toString() {
        return "ManagerEntity{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", actor=" + actor +
                ", charnam='" + charnam + '\'' +
                ", create_time=" + create_time +
                ", modify_time=" + modify_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerEntity that = (ManagerEntity) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(token, that.token) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(actor, that.actor) &&
                Objects.equals(charnam, that.charnam) &&
                Objects.equals(create_time, that.create_time) &&
                Objects.equals(modify_time, that.modify_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, password, token, phone, email, actor, charnam, create_time, modify_time);
    }
}
