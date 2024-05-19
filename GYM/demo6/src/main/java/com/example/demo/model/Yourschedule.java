package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Yourschedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "idkhachhang", nullable = false, length = 255)
    private String idkhachhang;
    @Basic
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Basic
    @Column(name = "start", nullable = false, length = 255)
    private String start;
    @Basic
    @Column(name = "end", nullable = false, length = 255)
    private String end;
    @Basic
    @Column(name = "confirmed", nullable = true, length = 255)
    private String confirmed;
    @Basic
    @Column(name = "reason", nullable = false, length = 255)
    private String reason;
    @Basic
    @Column(name = "location", nullable = false, length = 255)
    private String location;
    @Basic
    @Column(name = "resource", nullable = true)
    private Integer resource;
    @Basic
    @Column(name = "timecheck", nullable = true)
    private Timestamp timecheck;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(String idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getResource() {
        return resource;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
    }

    public Timestamp getTimecheck() {
        return timecheck;
    }

    public void setTimecheck(Timestamp timecheck) {
        this.timecheck = timecheck;
    }
}
