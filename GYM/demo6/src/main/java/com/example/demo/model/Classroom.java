package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Classroom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "mahocvien", nullable = false, length = 255)
    private String mahocvien;
    @Basic
    @Column(name = "malop", nullable = false, length = 255)
    private String malop;
    @Basic
    @Column(name = "tenhocvien", nullable = false, length = 255)
    private String tenhocvien;

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

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenhocvien() {
        return tenhocvien;
    }

    public void setTenhocvien(String tenhocvien) {
        this.tenhocvien = tenhocvien;
    }
}
