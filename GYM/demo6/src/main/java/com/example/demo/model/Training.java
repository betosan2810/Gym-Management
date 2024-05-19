package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Training {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = true)
    private int stt;
    @Basic
    @Column(name = "idteacher", nullable = true, length = 255)
    private String idteacher;
    @Basic
    @Column(name = "bomonday", nullable = true, length = 255)
    private String bomonday;
    @Basic
    @Column(name = "phongday", nullable = true, length = 255)
    private String phongday;
    @Basic
    @Column(name = "allday", nullable = true, length = 255)
    private String allday;
    @Basic
    @Column(name = "thoigianday", nullable = true, length = 255)
    private String thoigianday;
    @Basic
    @Column(name = "thoigianketthuc", nullable = true, length = 255)
    private String thoigianketthuc;
    @Basic
    @Column(name = "color", nullable = true, length = 255)
    private String color;
    @Basic
    @Column(name = "createtraining", nullable = true)
    private Timestamp createtraining;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(String idteacher) {
        this.idteacher = idteacher;
    }

    public String getBomonday() {
        return bomonday;
    }

    public void setBomonday(String bomonday) {
        this.bomonday = bomonday;
    }

    public String getPhongday() {
        return phongday;
    }

    public void setPhongday(String phongday) {
        this.phongday = phongday;
    }

    public String getAllday() {
        return allday;
    }

    public void setAllday(String allday) {
        this.allday = allday;
    }

    public String getThoigianday() {
        return thoigianday;
    }

    public void setThoigianday(String thoigianday) {
        this.thoigianday = thoigianday;
    }

    public String getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(String thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Timestamp getCreatetraining() {
        return createtraining;
    }

    public void setCreatetraining(Timestamp createtraining) {
        this.createtraining = createtraining;
    }
}
