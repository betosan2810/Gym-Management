package com.example.demo.services;

import com.example.demo.connection.DBConnection;
import com.example.demo.model.Tapthu;

import com.example.demo.responsitory.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class GymService {
    @Autowired
    public GymRepository gymRepository;
    @Autowired public static Connection conn = DBConnection.getConnection();

    public int addUserGymTT(Tapthu u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into tapthu(tenkh,sdtkh,bomon,thoigian,email) values (?,?,?,?,?)");
            pr.setNString(1,u.getTenkh());
            pr.setNString(2,u.getSdtkh());
            pr.setNString(3,u.getBomon());
            pr.setNString(4,u.getThoigian());
            pr.setNString(5,u.getEmail());
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }


}
