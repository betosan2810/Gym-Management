package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idteacher", nullable = false, length = 255)
    private String idteacher;
    @Basic
    @Column(name = "nameteacher", nullable = false, length = 255)
    private String nameteacher;
    @Basic
    @Column(name = "emailteacher", nullable = false, length = 255)
    private String emailteacher;
    @Basic
    @Column(name = "sdtteacher", nullable = false, length = 255)
    private String sdtteacher;
    @Basic
    @Column(name = "genderteacher", nullable = false, length = 255)
    private String genderteacher;
    @Basic
    @Column(name = "passteacher", nullable = false, length = 255)
    private String passteacher;
    @Basic
    @Column(name = "createteacher", nullable = true)
    private Timestamp createteacher;
    @Basic
    @Column(name = "avatar", nullable = true, length = 1000)
    private String avatar;

    public String getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(String idteacher) {
        this.idteacher = idteacher;
    }

    public String getNameteacher() {
        return nameteacher;
    }

    public void setNameteacher(String nameteacher) {
        this.nameteacher = nameteacher;
    }

    public String getEmailteacher() {
        return emailteacher;
    }

    public void setEmailteacher(String emailteacher) {
        this.emailteacher = emailteacher;
    }

    public String getSdtteacher() {
        return sdtteacher;
    }

    public void setSdtteacher(String sdtteacher) {
        this.sdtteacher = sdtteacher;
    }

    public String getGenderteacher() {
        return genderteacher;
    }

    public void setGenderteacher(String genderteacher) {
        this.genderteacher = genderteacher;
    }

    public String getPassteacher() {
        return passteacher;
    }

    public void setPassteacher(String passteacher) {
        this.passteacher = passteacher;
    }

    public Timestamp getCreateteacher() {
        return createteacher;
    }

    public void setCreateteacher(Timestamp createteacher) {
        this.createteacher = createteacher;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
