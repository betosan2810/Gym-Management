package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Khachhang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "makh", nullable = false, length = 255)
    private String makh;
    @Basic
    @Column(name = "tenkh", nullable = false, length = 255)
    private String tenkh;
    @Basic
    @Column(name = "sdtkh", nullable = false, length = 255)
    private String sdtkh;
    @Basic
    @Column(name = "emailkh", nullable = false, length = 255)
    private String emailkh;
    @Basic
    @Column(name = "gender", nullable = false, length = 255)
    private String gender;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "role", nullable = true, length = 255)
    private String role;
    @Basic
    @Column(name = "level", nullable = true, length = 255)
    private String level;
    @Basic
    @Column(name = "point", nullable = true)
    private Integer point;
    @Basic
    @Column(name = "createaccount", nullable = true)
    private Timestamp createaccount;
    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSdtkh() {
        return sdtkh;
    }

    public void setSdtkh(String sdtkh) {
        this.sdtkh = sdtkh;
    }

    public String getEmailkh() {
        return emailkh;
    }

    public void setEmailkh(String emailkh) {
        this.emailkh = emailkh;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Timestamp getCreateaccount() {
        return createaccount;
    }

    public void setCreateaccount(Timestamp createaccount) {
        this.createaccount = createaccount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
