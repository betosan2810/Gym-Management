package com.example.demo.responsitory;

import com.example.demo.model.Yourschedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface YourScheduleRepository extends JpaRepository<Yourschedule,Integer> {

    @Query("select s from Yourschedule s where s.idkhachhang =?1")
    ArrayList<Yourschedule> getScheduleFromIDKH(String id);
}
