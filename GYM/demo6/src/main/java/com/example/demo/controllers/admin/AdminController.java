package com.example.demo.controllers.admin;

import com.example.demo.model.Employee;
import com.example.demo.model.Khachhang;
import com.example.demo.print.Print;
import com.example.demo.responsitory.*;
import com.example.demo.services.GymService;
import com.example.demo.services.TeacherService;
import com.example.demo.services.XepLichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.http.HttpRequest;
import java.util.Map;

@Controller
@RequestMapping("employee")
public class AdminController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    HttpSession session;

    @Autowired
    KhachhangRepository khachhangRepository;

    @Autowired
    Print print;

    @Autowired
    XepLichRepository xepLichRepository;

    @Autowired
    XepLichService xepLichService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    YourScheduleRepository yourScheduleRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired GymRepository gymRepository;

    @Autowired
    GymService gymService;

    //~~~~roleEmp: lấy quyền từ database: Quản lý, Lễ tân, Kế toán

    //TRANG QUẢN LÝ
    @GetMapping("/quanly")
    public String QuanLyHome(Model model) {
        if (session.getAttribute("roleEmp").equals("Quản lý")) {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));  //lấy ra thong tin quanly
            return "/quanly/homeql";
        } else
            return "redirect:/login";
    }

    //TRANG LỄ TÂN
    @GetMapping("/letan")
    public String LeTanHome(Model model) {
        if (session.getAttribute("roleEmp").equals("Lễ tân")) {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            return "/quanly/homeql";
        } else
            return "redirect:/login";
    }


    @GetMapping(value = {"/", ""})
    public String Employment(Model model) {
        String role = "";
        if (session.getAttribute("roleEmp") == null)
            role = "";
        else
            role = (String) session.getAttribute("roleEmp");
        if (role.equals("Quản lý"))
            return "redirect:/employee/quanly";
        if (role.equals("Lễ tân"))
            return "redirect:/employee/letan";
        if (role.equals("")) {
            model.addAttribute("employee", new Employee());
            return "loginemployee";
        }
        return "loginemployee";

    }

    @PostMapping("/login")
    public String EmploymentLogin(@RequestParam Map<String, String> requestParam, Model model, @Valid Employee emp) {
        String idemp = requestParam.get("idemp");
        String passemp = requestParam.get("passemp");

        if (employeeRepository.getEmployeeByIDAndPass(idemp, passemp) != null) {
            String role = employeeRepository.getEmployeeByIDAndPass(idemp, passemp).getPositionemp();
            session.setAttribute("roleEmp", role);
            session.setAttribute("idEmp", idemp);
            if (role.equals("Quản lý")) {
                return "redirect:/employee/quanly";
            }
            if (role.equals("Lễ tân")) {
                return "redirect:/employee/letan";
            }
        }
        return "loginemployee";
    }

    //TRANG QUẢN LÝ NHÂN VIÊN
    @GetMapping("/quanly/quanly-nhanvien")
    public String QuanLyNhanVien(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dsnv",employeeRepository.findAll());
            return "/quanly/nhanvienql";
        } else
            return "redirect:/employee";
    }

    //TRANG QUẢN LÝ KHÁCH HÀNG
    @GetMapping(value = {"/quanly/quanly-khachhang","/letan/quanly-khachhang"})
    public String QuanLyKhachHang(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")||session.getAttribute("roleEmp").equals("Lễ tân"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dskh",khachhangRepository.findAll());
            return "/quanly/khachhangql";
        } else
            return "redirect:/employee";
    }

    //TRANG QUẢN LÝ HLV
    @GetMapping(value = {"/quanly/quanly-hlv","/letan/quanly-hlv"})
    public String QuanLyHLV(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")||session.getAttribute("roleEmp").equals("Lễ tân"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dshlv",teacherRepository.getAllTeacherDESC());
            return "/quanly/hlvql";
        } else
            return "redirect:/employee";
    }


    //TRANG QUẢN LÝ XẾP LỊCH
    @GetMapping(value = {"/quanly/quanly-xeplich","/letan/quanly-xeplich"})
    public String QuanLyXepLich(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")||session.getAttribute("roleEmp").equals("Lễ tân"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dskh",khachhangRepository.findAll());
            model.addAttribute("datalichday",xepLichRepository.findAll());
            model.addAttribute("listhlv",teacherService.idteacher_nameteacher());
            model.addAttribute("stt_idteacher",xepLichService.stt_idteacher());

            return "/quanly/xeplich";
        } else
            return "redirect:/login";
    }
    //IN DANH SÁCH NHÂN VIÊN
    @GetMapping("/quanly/quanly-nhanvien-in")
    public String PrintNV(Model model) throws Exception
    {
        print.WriteExcelStaff(employeeRepository.findAll());
        return "/quanly/nhanvienql";
    }
    //IN DANH SÁCH HLV
    @GetMapping("/quanly/quanly-hlv-in")
    public String PrintHLV(Model model) throws Exception
    {
        print.WriteExcelHLV(teacherRepository.findAll());
        return "/quanly/nhanvienql";
    }

    //IN DANH SÁCH KHÁCH HÀNG
    @GetMapping("/quanly/quanly-khachhang/in")
    public String PrintKH(Model model) throws Exception
    {
        print.WriteExcelCustomer(khachhangRepository.findAll());
        return "/quanly/khachhangql";
    }

    //XEM LỊCH TẬP CỦA KHÁCH HÀNG THÔNG QUA ID
    @GetMapping(value = {"/khachhang/lichtap/{idkh}"})
    public String GetScheduleByIDKH(@PathVariable String idkh,Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")||session.getAttribute("roleEmp").equals("Lễ tân"))
        {
            model.addAttribute("yourschedule",yourScheduleRepository.getScheduleFromIDKH(idkh));
            model.addAttribute("nameaccount",khachhangRepository.getKhachHangByMaKH(idkh).getTenkh());
            model.addAttribute("roleaccount",true); //phân quyền có được sửa lịch hay không
            return "yourschedule";
        }
        else
        {
            return "redirect:/login";
        }
    }

    //XEM DANH SÁCH KHÁCH HÀNG TẬP THỬ
    @GetMapping("/letan/quanly-tapthu")
    public String GetListDataTapThu(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Lễ tân"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dstapthu",gymRepository.findAll());
            return "/quanly/tapthuql";
        }
        else
            return "redirect:/login";
    }

    @GetMapping("/logout")
    public String LogOut()
    {
        session.invalidate();
        return "redirect:/employee";
    }

}
