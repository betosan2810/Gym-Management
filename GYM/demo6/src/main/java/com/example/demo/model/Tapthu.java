package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Tapthu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "tenkh", nullable = false, length = 255)
    private String tenkh;
    @Basic
    @Column(name = "sdtkh", nullable = false, length = 10)
    private String sdtkh;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "bomon", nullable = false, length = 255)
    private String bomon;
    @Basic
    @Column(name = "thoigian", nullable = false, length = 255)
    private String thoigian;
    @Basic
    @Column(name = "datedk", nullable = true)
    private Timestamp datedk;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBomon() {
        return bomon;
    }

    public void setBomon(String bomon) {
        this.bomon = bomon;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public Timestamp getDatedk() {
        return datedk;
    }

    public void setDatedk(Timestamp datedk) {
        this.datedk = datedk;
    }
}
