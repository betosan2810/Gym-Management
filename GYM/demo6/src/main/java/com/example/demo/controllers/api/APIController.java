package com.example.demo.controllers.api;

import com.example.demo.model.*;
import com.example.demo.responsitory.*;

import com.example.demo.services.EmployeeService;
import com.example.demo.services.KhachHangService;
import com.example.demo.services.TeacherService;
import com.example.demo.services.XepLichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("employee/quanly")
public class APIController {

    @Autowired
    HttpSession session;
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    XepLichRepository xepLichRepository;

    @Autowired
    XepLichService xepLichService;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;
    @Autowired
    YourScheduleRepository yourScheduleRepository;

    @Autowired KhachhangRepository khachhangRepository;

    @Autowired
    KhachHangService khachHangService;

    @Autowired GymRepository gymRepository;




    @GetMapping(value = {"security/api/employee"})
    public ResponseEntity<Iterable<Employee>> findAllBooking()
    {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    //THÊM NHÂN VIÊN
    @PostMapping(value = {"security/api/employee"})
    public ResponseEntity add(@RequestBody Employee emp)
    {
        employeeService.addNewEmployee(emp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //XÓA NHÂN VIÊN
    @DeleteMapping("security/api/employee/delete/{idemp}")
    public ResponseEntity Delete(@PathVariable String idemp)
    {
        employeeRepository.deleteEmployeeByID(idemp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping( "edit/employee")
    public Employee getInfoEmp(@RequestParam Map<String,String> requestParam)
    {
        return employeeRepository.getEmployeeByID(requestParam.get("idemp"));
    }

    //UPDATE THÔNG TIN NHÂN VIÊN
    @RequestMapping(value="/confirmedit/employee",method = RequestMethod.POST)
    public Employee editInfoEmp(@RequestParam Map<String,String> requestParam)
    {
        String idemp = requestParam.get("idemp");
        String tenemp = requestParam.get("tenemp");
        String email = requestParam.get("emailemp");
        String position = requestParam.get("positionemp");
        String sdtemp = requestParam.get("sdtemp");

        employeeRepository.updateEmployee(tenemp,email,sdtemp,position,idemp);
        return employeeRepository.getEmployeeByID(idemp);
    }

    @GetMapping("quanlylichday")
    public ResponseEntity<Iterable<Training>> QuanLyLichTap()
    {
        return new ResponseEntity<>(xepLichRepository.findAll(), HttpStatus.OK);
    }

    //XẾP LỊCH
    @PostMapping(value = {"quanlylichday/add"})
    public ResponseEntity addLichDay(@RequestBody Training training)
    {
        xepLichService.addNewScheduleForHLV(training);
        return new ResponseEntity<>(xepLichRepository.findAll(),HttpStatus.OK);
    }

    //XÓA XẾP LỊCH
    @DeleteMapping("quanlylichday/delete/{stt}")
    public ResponseEntity DeleteXepLich(@PathVariable int stt)
    {
        xepLichRepository.DeleteXepLich(stt);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //CẬP NHẬT LỊCH
    @RequestMapping(value="quanlylichday/edit",method = RequestMethod.POST)
    public ResponseEntity editLichDay(@RequestParam Map<String,String> requestParam)
    {
        String stt = requestParam.get("stt");
        String idteacher =requestParam.get("idteacher");
        String bomonday = requestParam.get("bomonday");
        String phongday = requestParam.get("phongday");
        String allday = requestParam.get("allday");
        String thoigianday = requestParam.get("thoigianday");
        String thoigianketthuc = requestParam.get("thoigianketthuc");
        String color = requestParam.get("color");

        xepLichRepository.updateXepLich(idteacher,bomonday,phongday,allday,thoigianday,thoigianketthuc,color,Integer.parseInt(stt));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //XÓA HLV
    @DeleteMapping("security/api/hlv/delete/{idhlv}")
    public ResponseEntity DeleteHLV(@PathVariable String idhlv)
    {
        teacherRepository.deleteHLVByID(idhlv);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //THÊM HLV
    @PostMapping(value = {"security/api/hlv/add"})
    public ResponseEntity addHLV(@RequestBody Teacher emp)
    {
        teacherService.addNewHLV(emp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //LẤY HLV CẦN SỬA
    @GetMapping( "edit/hlv")
    public Teacher getInfoHLV(@RequestParam Map<String,String> requestParam)
    {
        return teacherRepository.getTeacherByID(requestParam.get("idhlv"));
    }

    //CẬP NHẬT HLV
    @RequestMapping(value="/confirmedit/hlv",method = RequestMethod.POST)
    public Teacher editInfoHLV(@RequestParam Map<String,String> requestParam)
    {
        String idteacher = requestParam.get("idteacher");
        String nameteacher = requestParam.get("nameteacher");
        String emailteacher = requestParam.get("emailteacher");
        String genderteacher = requestParam.get("genderteacher");
        String sdtteacher = requestParam.get("sdtteacher");

        teacherRepository.updateHLV(nameteacher,emailteacher,sdtteacher,genderteacher,idteacher);
        return teacherRepository.getTeacherByID(idteacher);
    }

    ///XEM LỊCH CỦA CÁ NHÂN
    @GetMapping("security/api/yourschedule")
    public ResponseEntity getYourSchedule()
    {
        return new ResponseEntity<>(yourScheduleRepository.findAll(),HttpStatus.OK);
    }

    //XÓA KHÁCH HÀNG
    @DeleteMapping("security/api/khachhang/delete/{idemp}")
    public ResponseEntity DeleteKH(@PathVariable String idemp)
    {
        khachhangRepository.deleteKHByID(idemp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //LẤY THÔNG TIN KHÁCH HÀNG
    @GetMapping( "edit/khachhang")
    public Khachhang getInfoKH(@RequestParam Map<String,String> requestParam)
    {
        return khachhangRepository.getKhachHangByMaKH(requestParam.get("idkh"));
    }
    //CẬP NHẬT KHÁCH HÀNG
    @RequestMapping(value="/confirmedit/khachhang",method = RequestMethod.POST)
    public Khachhang editInfoKH(@RequestParam Map<String,String> requestParam)
    {
        String tenkh = requestParam.get("tenkh");
        String sdtkh = requestParam.get("sdtkh");
        String emailkh = requestParam.get("emailkh");
        String gender = requestParam.get("gender");
        String makh = requestParam.get("makh");
        String level = requestParam.get("level");
        String status = requestParam.get("status");
        khachhangRepository.updateKHFromAdmin(tenkh,sdtkh,emailkh,gender,level,status,makh);
        return khachhangRepository.getKhachHangByMaKH(makh);
    }
    //THÊM KHÁCH HÀNG
    @PostMapping(value = {"security/api/khachhang/add"})
    public ResponseEntity addHLV(@RequestBody Khachhang kh)
    {
        khachHangService.addNewCustomerFromAdmin(kh);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //XÓA KHÁCH HÀNG
    @DeleteMapping("security/api/tapthu/delete/{stt}")
    public ResponseEntity DeleteKH(@PathVariable int stt)
    {
        gymRepository.deleteKHTapThu(stt);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //QUÊN MẬT KHẨU

//    @PostMapping("/forgot")
//    public ResponseEntity ForgotPass(@RequestParam Map<String,String> requestParam) {
//        sendmail = new Sendmail();
//        String emailkh = requestParam.get("emailkh");
//        sendmail.SendMail(emailkh);
//        return  new ResponseEntity<>(HttpStatus.OK);
//    }
//    @RequestMapping(value = "/sendemail")
//    public String sendEmail()
//    {
//       sendmail = new Sendmail();
//       sendmail.sendEmail("vanhuy1619@gmail.com");
//        return "ok";
//    }

}
