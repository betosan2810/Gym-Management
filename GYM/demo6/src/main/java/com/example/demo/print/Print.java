package com.example.demo.print;

import java.io.File;

import com.example.demo.model.Employee;
import com.example.demo.model.Khachhang;
import com.example.demo.model.Teacher;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Service
public class Print  {
    public boolean WriteExcelStaff(List list) throws Exception
    {
        List<Employee> listemp = list;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(" Staff Data ");
        XSSFRow row;
        Map<String, Object[]> staffData = new TreeMap<String, Object[]>();

        staffData.put("1", new Object[] { "Mã nhân viên", "Tên nhân viên", "Số điện thoại","Email","Gender","Chức vụ","Thời gian vào làm" });
        for(int i=0;i<listemp.size();i++)
        {
            staffData.put(String.valueOf(i+2),new Object[]{listemp.get(i).getIdemp(),listemp.get(i).getTenemp(),listemp.get(i).getSdtemp(),listemp.get(i).getEmailemp(),
                                                                listemp.get(i).getGenderemp(),listemp.get(i).getPositionemp(),String.valueOf(listemp.get(i).getCreateemp())});
        }
        Set<String> keyid = staffData.keySet();
        int rowid = 0;
        for(String key : keyid)
        {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = staffData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        FileOutputStream out = new FileOutputStream(new File("C:/Users/ASUS/Desktop/StaffData.xlsx"));

        workbook.write(out);
        out.close();
        return true;
    }

    public boolean WriteExcelCustomer(List list) throws Exception
    {
        List<Khachhang> listCus = list;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Customer Data ");
        XSSFRow row;
        Map<String, Object[]> customerData = new TreeMap<String, Object[]>();

        customerData.put("1", new Object[] { "Mã khách hàng", "Tên khách hàng", "Email","Số điện thoại","Giới tính","Hạng thẻ","Điểm tích lũy","Thời gian đăng ký","Hiệu lực" });
        for(int i=0;i<listCus.size();i++)
        {
            customerData.put(String.valueOf(i+2),new Object[]{
                    listCus.get(i).getMakh(),listCus.get(i).getTenkh(),listCus.get(i).getEmailkh(),
                    listCus.get(i).getSdtkh(), listCus.get(i).getGender(),listCus.get(i).getLevel(),
                    String.valueOf(listCus.get(i).getPoint()),String.valueOf(listCus.get(i).getCreateaccount()),listCus.get(i).getStatus()});
        }
        Set<String> keyid = customerData.keySet();
        int rowid = 0;
        for(String key : keyid)
        {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = customerData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        FileOutputStream out = new FileOutputStream(new File("C:/Users/ASUS/Desktop/CustomerData.xlsx"));

        workbook.write(out);
        out.close();
        return true;
    }

    public boolean WriteExcelHLV(List list) throws Exception
    {
        List<Teacher> listCus = list;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("HLV Data ");
        XSSFRow row;
        Map<String, Object[]> customerData = new TreeMap<String, Object[]>();

        customerData.put("1", new Object[] { "Mã HLV", "Họ và tên", "Email","Số điện thoại","Giới tính","Thời gian vào làm" });
        for(int i=0;i<listCus.size();i++)
        {
            customerData.put(String.valueOf(i+2),new Object[]{listCus.get(i).getIdteacher(),listCus.get(i).getNameteacher(),listCus.get(i).getEmailteacher(),listCus.get(i).getSdtteacher(),
                    listCus.get(i).getGenderteacher(),String.valueOf(listCus.get(i).getCreateteacher())});
        }
        Set<String> keyid = customerData.keySet();
        int rowid = 0;
        for(String key : keyid)
        {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = customerData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        FileOutputStream out = new FileOutputStream(new File("C:/Users/ASUS/Desktop/HLVData.xlsx"));

        workbook.write(out);
        out.close();
        return true;
    }
}
