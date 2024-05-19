package com.example.demo.services;

import com.example.demo.connection.DBConnection;
import com.example.demo.model.Employee;
import com.example.demo.model.Teacher;
import com.example.demo.responsitory.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired public static Connection conn = DBConnection.getConnection();

    public HashMap<String,String> idteacher_nameteacher()
    {
        HashMap<String,String> hashMap = new HashMap<>();
        for(int i = 0; i<teacherRepository.findAll().size();i++)
        {
            hashMap.put(teacherRepository.findAll().get(i).getIdteacher(),
                    teacherRepository.findAll().get(i).getNameteacher());
        }
        return hashMap;
    }

    public String setIDForHLV()
    {
        String numPosition = "";

        if(teacherRepository.getAllIDHLV().size()==0)
            numPosition = "1";
        else
        {
            List<String> list = teacherRepository.getAllIDHLV();
            ArrayList<Integer> listcount = new ArrayList<>();
            for(int i=0;i<list.size();i++)
            {
                listcount.add(Integer.parseInt(list.get(i).substring(2)));
            }
            numPosition = String.valueOf(Collections.max(listcount)+1);
        }

        if(numPosition.length()==1)
            return "tc"+"00"+numPosition;
        else if(numPosition.length()==2)
            return "tc"+"0"+numPosition;
        else
            return "tc"+numPosition;
    }

    public int addNewHLV(Teacher u) {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into teacher(idteacher,nameteacher,emailteacher,sdtteacher,genderteacher,passteacher) values (?,?,?,?,?,?)");
            pr.setNString(1, setIDForHLV());
            pr.setNString(2, u.getNameteacher());
            pr.setNString(3, u.getEmailteacher());
            pr.setNString(4, u.getSdtteacher());
            pr.setNString(5, u.getGenderteacher());
            pr.setNString(6, u.getPassteacher());
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }

}
