package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Schedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = true)
    private int stt;
    @Basic
    @Column(name = "city", nullable = false, length = 255)
    private String city;
    @Basic
    @Column(name = "idclb", nullable = false, length = 255)
    private String idclb;
    @Basic
    @Column(name = "ngay", nullable = false, length = 255)
    private String ngay;
    @Basic
    @Column(name = "bomon", nullable = false, length = 255)
    private String bomon;
    @Basic
    @Column(name = "img", nullable = false, length = 255)
    private String img;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdclb() {
        return idclb;
    }

    public void setIdclb(String idclb) {
        this.idclb = idclb;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getBomon() {
        return bomon;
    }

    public void setBomon(String bomon) {
        this.bomon = bomon;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
