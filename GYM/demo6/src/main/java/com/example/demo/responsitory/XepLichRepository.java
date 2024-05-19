package com.example.demo.responsitory;

import com.example.demo.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface XepLichRepository extends JpaRepository<Training,Integer> {

    @Modifying
    @Transactional
    @Query("delete from Training s where s.stt =?1")
    void DeleteXepLich(int stt);

    @Modifying
    @Transactional
    @Query("update Training s set s.idteacher=?1, s.bomonday=?2,s.phongday=?3,s.allday=?4,s.thoigianday=?5,s.thoigianketthuc=?6,s.color=?7 where s.stt=?8")
    void updateXepLich(String idteacher,String bomonday,String phongday, String allday,String thoigiandạy,String thoigianketthuc,String color,int stt);

    @Query("select s.idteacher from Training s where s.stt=?1")
    String getIDTeacherBySTTXepLich(int stt);
}
