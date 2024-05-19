package com.example.demo.responsitory;

import com.example.demo.model.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface KhachhangRepository extends JpaRepository<Khachhang,Integer> {
    @Query("select s from Khachhang s where s.sdtkh=?1 and s.emailkh=?2")
    Khachhang findKHByPhoneAndEmail(String sdt,String email);

    @Query("select s from Khachhang s where s.emailkh = ?1")
    Khachhang getKhachHangByEmail(String eamil);

    @Query("select s from Khachhang s where s.emailkh = ?1 and s.password = ?2")
    Khachhang getKhachHangByEmailAndPassword(String email,String password);

    @Query("select s from Khachhang s where s.makh = ?1")
    Khachhang getKhachHangByMaKH(String makh);

    @Modifying
    @Transactional
    @Query("update Khachhang s set s.tenkh =?1, s.sdtkh =?2,s.gender =?3 where s.makh = ?4")
    void updateKHNotPass(String name, String sdt, String gender, String id);

    @Modifying
    @Transactional
    @Query("update Khachhang s set s.tenkh =?1, s.sdtkh =?2,s.gender =?3,s.password=?4 where s.makh = ?5")
    void updateKHWithPass(String name, String sdt, String gender,String pass,String id);
    @Modifying
    @Transactional
    @Query("delete from Khachhang s where s.makh = ?1")
    void deleteKHByID(String idkh);

    @Modifying
    @Transactional
    @Query("update Khachhang s set s.tenkh =?1, s.sdtkh =?2,s.emailkh =?3,s.gender=?4,s.level=?5,s.status=?6 where s.makh = ?7")
    void updateKHFromAdmin(String name, String sdt, String email,String gender,String level,String status,String id);


}
