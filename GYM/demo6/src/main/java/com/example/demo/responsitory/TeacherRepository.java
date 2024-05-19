package com.example.demo.responsitory;

import com.example.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,String> {

    @Modifying
    @Transactional
    @Query("delete from Teacher s where s.idteacher=?1")
    void deleteHLVByID(String idhlv);

    @Query("select s from Teacher s where s.idteacher=?1")
    Teacher getTeacherByID(String id);

    @Modifying
    @Transactional
    @Query("update Teacher s set s.nameteacher=?1,s.emailteacher=?2,s.sdtteacher=?3,s.genderteacher=?4 where s.idteacher=?5")
    void updateHLV(String name,String email,String sdt, String gender, String id);

    @Query("select s.idteacher from Teacher s")
    List<String> getAllIDHLV();

    @Query("select s from Teacher s order by s.createteacher desc ")
    List<Teacher> getAllTeacherDESC();
}
