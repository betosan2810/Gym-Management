package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Hocvien {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "mahocvien", nullable = false, length = 255)
    private String mahocvien;
    @Basic
    @Column(name = "tenhocvien", nullable = false, length = 255)
    private String tenhocvien;
    @Basic
    @Column(name = "bomondk", nullable = false, length = 255)
    private String bomondk;
    @Basic
    @Column(name = "thoigiandk", nullable = false, length = 255)
    private String thoigiandk;
    @Basic
    @Column(name = "thoigianketthuc", nullable = false, length = 255)
    private String thoigianketthuc;
    @Basic
    @Column(name = "createdkhocvien", nullable = false)
    private Timestamp createdkhocvien;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMahocvien() {
        return mahocvien;
    }

    public void setMahocvien(String mahocvien) {
        this.mahocvien = mahocvien;
    }

    public String getTenhocvien() {
        return tenhocvien;
    }

    public void setTenhocvien(String tenhocvien) {
        this.tenhocvien = tenhocvien;
    }

    public String getBomondk() {
        return bomondk;
    }

    public void setBomondk(String bomondk) {
        this.bomondk = bomondk;
    }

    public String getThoigiandk() {
        return thoigiandk;
    }

    public void setThoigiandk(String thoigiandk) {
        this.thoigiandk = thoigiandk;
    }

    public String getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(String thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public Timestamp getCreatedkhocvien() {
        return createdkhocvien;
    }

    public void setCreatedkhocvien(Timestamp createdkhocvien) {
        this.createdkhocvien = createdkhocvien;
    }
}
