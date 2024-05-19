package com.example.demo.controllers.user;

import com.cloudinary.utils.ObjectUtils;
import com.example.demo.model.Employee;
import com.example.demo.model.Khachhang;
import com.example.demo.model.Tapthu;
import com.example.demo.model.Yourschedule;
import com.example.demo.responsitory.GymRepository;
import com.example.demo.responsitory.KhachhangRepository;
import com.example.demo.responsitory.ScheduleRepository;
import com.example.demo.responsitory.YourScheduleRepository;

import com.example.demo.services.GymService;
import com.example.demo.services.KhachHangService;
import org.cloudinary.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

@Controller
public class UserController {

    @Autowired
    HttpSession session;

    @Autowired
    GymService gymService;
    @Autowired
    GymRepository gymRepository;

    @Autowired
    KhachhangRepository khachhangRepository;

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    ScheduleRepository scheduleRepository;



    @Autowired
    YourScheduleRepository yourScheduleRepository;

    @GetMapping(value = {"","/"})
    public String HomePage()
    {
        return "home";
    }

    @GetMapping("/lichtap")
    public ModelAndView ShowLichTap(@RequestParam Map<String,String> requestParam,Model model)
    {
        String img = scheduleRepository.IMG(requestParam.get("city"),requestParam.get("idclb"),requestParam.get("ngay"),requestParam.get("bomon"));
        ModelAndView modelAndView = new ModelAndView("lichtap");
        modelAndView.addObject("img", img);
        return modelAndView;

    }

    @GetMapping("/tapthu")
    public String TapThuPage(Model model)
    {
        model.addAttribute("tt",new Tapthu());
        return "tapthu";
    }
    @PostMapping("/tapthu")
    public String HomeGymSign (@RequestParam Map<String,String> requestParam, Model model, @Valid Tapthu tapthu, BindingResult result)
    {
        String tenkh = requestParam.get("tenkh");
        String sdtkh = requestParam.get("sdtkh");
        String bomon = requestParam.get("bomon");
        String thoigian = requestParam.get("thoigian");
        String emailkh = requestParam.get("emailkh");

        tapthu.setTenkh(tenkh);
        tapthu.setSdtkh(sdtkh);
        tapthu.setBomon(bomon);
        tapthu.setThoigian(thoigian);
        tapthu.setEmail(emailkh);

        model.addAttribute("tt",tapthu);
        if(gymRepository.checkSDTTapThu(sdtkh)==null)
        {
            gymService.addUserGymTT(tapthu);
            model.addAttribute("tttc","Bạn đã đăng ký tập thử thành công! Nhân viên chúng tôi sẽ liên lạc cho bạn trong thời gian sớm nhất");
//            return "tapthu";
        }
        else
        {
            model.addAttribute("errtt","Số điện thoại đã được sử dụng đăng ký tập thử một lần");

        }
        return "tapthu";

    }



    @GetMapping("/log")
    public String LogPage(Model model)
    {
        model.addAttribute("khachhang",new Khachhang());
        return "log-in-out";
    }

    //ĐĂNG KÝ TÀI KHOẢN
    @PostMapping("/log")
    public String Regist (@RequestParam Map<String,String> requestParam, Model model, @Valid Khachhang kh,  BindingResult result)
    {
        String tenkh = requestParam.get("tenkh");
        String emailkh = requestParam.get("emailkh");
        String sdtkh = requestParam.get("sdtkh");
        String genderkh = requestParam.get("genderkh");
        String passwordkh = requestParam.get("passwordkh");


        kh.setTenkh(tenkh);
        kh.setEmailkh(emailkh);
        kh.setSdtkh(sdtkh);
        kh.setGender(genderkh);
        kh.setPassword(passwordkh);

        model.addAttribute("khachhang",kh);

        if(khachhangRepository.findKHByPhoneAndEmail(sdtkh,emailkh)==null)
        {
            khachHangService.addNewCustomer(kh);
            model.addAttribute("err","Vui lòng kiểm tra email để xác thực tài khoản");
        }
        else
        {
            model.addAttribute("errRegist","Tài khoản email hoặc số điện thoại đã được đăng ký trước đó");
        }

        return "log-in-out";
    }

    //ĐĂNG NHẬP
    @PostMapping("/login")
    public String Login (@RequestParam Map<String,String> requestParam, Model model, @Valid Khachhang kh,  BindingResult result)
    {
        String email = requestParam.get("emailkh");
        String password = requestParam.get("password");

        kh.setEmailkh(email);
        kh.setPassword(password);

        model.addAttribute("khachhang",kh);

        if(khachhangRepository.getKhachHangByEmailAndPassword(email,password)!=null)
        {
            session.setAttribute("inforLogin",khachhangRepository.getKhachHangByEmailAndPassword(email,password).getMakh());
            return "redirect:/user/profile";
        }
        else
        {
            model.addAttribute("errlogin","Tài khoản đăng nhập không hợp lệ");
            return "log-in-out";
        }
    }

    //PROFILE
    @GetMapping("/user/profile")
    public String Profile(Model model)
    {
        if(session.getAttribute("inforLogin")!="")
        {
            String iduser = (String) session.getAttribute("inforLogin");
            model.addAttribute("user",khachhangRepository.getKhachHangByMaKH(iduser));
            return "profile";
        }
        else
            return "rdirect:/";
    }

    //CẬP NHẬT THÔNG TIN
    @PostMapping("/user/profile")
    public String UpdateProfile (@RequestParam Map<String,String> requestParam,Model model, @Valid Khachhang kh,  BindingResult result)
    {
        String tenkh = requestParam.get("tenkh");
        String sdt = requestParam.get("sdtkh");
        String gender = requestParam.get("gender");
        String iduser = (String) session.getAttribute("inforLogin");

        String pass = requestParam.get("password");

        if(pass==null)
            khachhangRepository.updateKHNotPass(tenkh,sdt,gender,iduser);
        if(pass!=null)
            khachhangRepository.updateKHWithPass(tenkh,sdt,gender,pass,iduser);
        model.addAttribute("updatetxt","Cập nhật thông tin thành công");

        return "redirect:/user/profile";
    }

    //SCHEDULE
    @GetMapping("/user/profile/schedule")
    public String Schedule(Model model)
    {
        if(session.getAttribute("inforLogin")!="")
        {
            String iduser = (String) session.getAttribute("inforLogin");
            model.addAttribute("user",khachhangRepository.getKhachHangByMaKH(iduser));
            model.addAttribute("yourschedule",yourScheduleRepository.getScheduleFromIDKH(iduser));
            model.addAttribute("nameaccount",khachhangRepository.getKhachHangByMaKH(iduser).getTenkh());
            model.addAttribute("roleaccount",false); //phân quyền có được sửa lịch hay không
            return "yourschedule";
        }
        else
            return "rdirect:/";
    }

    @GetMapping("/logout")
    public String LogOut()
    {
        session.invalidate();
        return "redirect:/";
    }

}
