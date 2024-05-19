package com.example.demo;



import com.example.demo.API.API;
import com.example.demo.model.Employee;
import com.example.demo.model.Khachhang;
import com.example.demo.model.Tapthu;
import com.example.demo.model.Training;
import com.example.demo.print.Print;
import com.example.demo.responsitory.*;

import com.example.demo.services.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootTest
class Demo6ApplicationTests {



    @Autowired
    GymService gymService;

    @Autowired
    GymRepository gymRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired KhachHangService khachHangService;

    @Autowired
    KhachhangRepository khachhangRepository;

    @Autowired
    Print print;


    @Autowired EmployeeService employeeService;

    @Autowired XepLichService xepLichService;

    @Autowired
    XepLichRepository xepLichRepository;

    @Autowired
    YourScheduleRepository yourScheduleRepository;

    @Autowired TeacherService teacherService;

    @Test
    void contextLoads() throws Exception
    {
        API api =new API();
        Tapthu u = new Tapthu();
        u.setTenkh("Huy");
        u.setEmail("vh@gmail.com");
        u.setBomon("Yoga");
        u.setThoigian("17h-18h");
        u.setSdtkh("0123456789");

//        if(gymService.checkStdTapThu(u.getSdtkh())==true)
//        {
//            System.out.println("Add tc");
//            gymService.addUserGymTT(u);
//        }
//        else
//            System.out.println("Fail");
//        System.out.println(gymRepository.checkSDTTapThu("0123456788"));

        Khachhang kh = new Khachhang();
        kh.setTenkh("Nguyễn Thị Anh Thư");
        kh.setGender("Female");
        kh.setPassword("123456");
        kh.setSdtkh("0929099064");
        kh.setEmailkh("vanhuy1619@gmail.com");
//        if(khachhangRepository.findKHByPhoneAndEmail(kh.getSdtkh(),kh.getEmailkh())==null)
//            khachHangService.addNewCustomer(kh);
//        System.out.println(khachhangRepository.findKHByPhoneAndEmail("0929099064","vanhuy1x619@gmail.com"));
//        try {
//
//            System.out.println(print.WriteExcel(employeeRepository.findAll()));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(employeeRepository.findAll().get(0).toString());

//        khachhangRepository.updateKHWithPass("Mai Hồng Ngọc","0147852369","Female","khoanguyen30lb@gmail.com","123456","Upl9fatp");
//        System.out.println(khachhangRepository.getKhachHangByMaKH("Upl9fatp"));

//        sendmail.SendMail("vanhuy1619@gmail.com");
//        System.out.println(employeeRepository.countPosition("H"));
//        System.out.println(employeeService.setIDForEmp("Quản lý"));

        Employee e = new Employee();
        e.setTenemp("Nguyễn Thúc Thùy Tiên");
        e.setGenderemp("Male");
        e.setSdtemp("0101010107");
        e.setEmailemp("ntt3t@gmail.com");
        e.setPositionemp("Lễ tân");
        e.setPassemp("123456");
//        System.out.println(employeeService.setIDForEmp(e.getPositionemp()));
//        employeeService.addNewEmployee(e);
//        employeeRepository.deleteEmployeeByID("kt000001");
//        employeeRepository.updateEmployee("hh","@","528","ì","kt000007");
//        System.out.println(gymRepository.checkSDTTapThu("0929099063"));

        Training tr = new Training();
        tr.setIdteacher("tc001");
        tr.setBomonday("Boxing");
        tr.setPhongday("T-2");
        tr.setAllday("false");
        tr.setThoigianday("2022-12-10T17:45");
        tr.setThoigianketthuc("2022-12-10T19:00");
        tr.setColor("#a50000");
//        xepLichService.addNewScheduleForHLV(tr);

//        System.out.println(xepLichRepository.findAll());
//        System.out.println(api.webclient("http://localhost:3000/listhotel"));
//        xepLichRepository.updateXepLich("G","dx","dx",);
//        System.out.println(yourScheduleRepository.getScheduleFromIDKH("mMr0u8XA").get(0));
//        System.out.println(teacherService.setIDForHLV());
//        print.WriteExcelCustomer(khachhangRepository.findAll());


    }


}
