package com.example.demo.services;

import com.example.demo.model.Yourschedule;
import com.example.demo.responsitory.YourScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YourScheduleService {

    @Autowired
    private YourScheduleRepository yourScheduleRepository;

    public Yourschedule addSchedule(Yourschedule schedule) {
        return yourScheduleRepository.save(schedule);
    }

    public Yourschedule updateSchedule(Yourschedule schedule) {
        Optional<Yourschedule> existingSchedule = yourScheduleRepository.findById(schedule.getStt());
        if (existingSchedule.isPresent()) {
            return yourScheduleRepository.save(schedule);
        } else {
            throw new RuntimeException("Schedule not found");
        }
    }

    public void deleteSchedule(int stt) {
        yourScheduleRepository.deleteById(stt);
    }

    public List<Yourschedule> getSchedulesByCustomerId(String idkhachhang) {
        return yourScheduleRepository.findByIdkhachhang(idkhachhang);
    }
}
