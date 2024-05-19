package com.example.demo.responsitory;

import com.example.demo.model.Tapthu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


//TẬP THỬ
public interface GymRepository extends JpaRepository<Tapthu,Integer> {
    @Query("select s from Tapthu s where s.sdtkh =?1")
    Tapthu checkSDTTapThu(String sdt);

    @Modifying
    @Transactional
    @Query("delete from Tapthu s where s.stt=?1")
    void deleteKHTapThu(int stt);
}
