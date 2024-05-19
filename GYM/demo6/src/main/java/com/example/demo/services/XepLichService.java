package com.example.demo.services;

import com.example.demo.connection.DBConnection;
import com.example.demo.model.Khachhang;
import com.example.demo.model.Training;
import com.example.demo.responsitory.XepLichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

@Service
public class XepLichService {

    @Autowired
    XepLichRepository xepLichRepository;
    @Autowired
    public static Connection conn = DBConnection.getConnection();
    public int addNewScheduleForHLV(Training u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into training(idteacher,bomonday,phongday,allday,thoigianday,thoigianketthuc,color) values (?,?,?,?,?,?,?)");
            pr.setNString(1,u.getIdteacher());
            pr.setNString(2,u.getBomonday());
            pr.setNString(3,u.getPhongday());
            pr.setNString(4,u.getAllday());
            pr.setNString(5,u.getThoigianday());
            pr.setNString(6,u.getThoigianketthuc());
            pr.setNString(7,u.getColor());
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }
    public HashMap<Integer,String> stt_idteacher()
    {
        HashMap<Integer,String> hashMap = new HashMap<>();
        for(int i = 0; i<xepLichRepository.findAll().size();i++)
        {
            hashMap.put(xepLichRepository.findAll().get(i).getStt(),
                    xepLichRepository.findAll().get(i).getIdteacher());
        }
        return hashMap;
    }


}
