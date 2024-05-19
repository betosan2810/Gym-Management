package com.example.demo.services;

import com.example.demo.connection.DBConnection;
import com.example.demo.model.Khachhang;
import com.example.demo.model.Tapthu;
import com.example.demo.responsitory.KhachhangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

@Service
public class KhachHangService {

    @Autowired
    KhachhangRepository khachhangRepository;

    @Autowired
    public static Connection conn = DBConnection.getConnection();

    public String randomID()
    {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public String randomPassword()
    {
        String SALTCHARS = "012345678901234567890147852369";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public int addNewCustomer(Khachhang u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into khachhang(tenkh,emailkh,sdtkh,gender,password,makh,status) values (?,?,?,?,?,?,?)");
            pr.setNString(1,u.getTenkh());
            pr.setNString(2,u.getEmailkh());
            pr.setNString(3,u.getSdtkh());
            pr.setNString(4,u.getGender());
            pr.setNString(5,u.getPassword());
            pr.setNString(6,randomID());
            pr.setNString(7,"Chờ duyệt");
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }

    public int addNewCustomerFromAdmin(Khachhang u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into khachhang(tenkh,emailkh,sdtkh,gender,password,makh,status) values (?,?,?,?,?,?,?)");
            pr.setNString(1,u.getTenkh());
            pr.setNString(2,u.getEmailkh());
            pr.setNString(3,u.getSdtkh());
            pr.setNString(4,u.getGender());
            pr.setNString(5,randomPassword());
            pr.setNString(6,randomID());
            pr.setNString(7,"Hoạt động");
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }



}
