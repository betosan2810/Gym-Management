package com.example.demo.responsitory;

import com.example.demo.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    @Query("select s.img from Schedule s where s.city =?1 and s.idclb=?2 and s.ngay =?3 and s.bomon =?4")
    String IMG(String city,String idclb, String ngay, String bomon);
}
