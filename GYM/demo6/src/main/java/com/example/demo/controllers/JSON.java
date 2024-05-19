package com.example.demo.controllers;

import com.example.demo.model.Schedule;
import com.example.demo.responsitory.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JSON {
    @Autowired
    ScheduleRepository scheduleRepository;


    @GetMapping(value = {"/schedule"})
    public String getLichTap(@RequestParam Map<String,String> requestParam)
    {
        return (scheduleRepository.IMG(requestParam.get("city"),requestParam.get("idclb"),requestParam.get("ngay"),requestParam.get("bomon")));
    }
}
