package com.evan.sj.controller;

import com.evan.sj.pojo.Passenger;
import com.evan.sj.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @GetMapping("/api/passengers")
    public List<Passenger> list() throws Exception {
        return passengerService.list();
    }

    @PostMapping("/api/passengers")
    public Passenger addOrUpdate(@RequestBody Passenger passenger) throws Exception {
        passengerService.addOrUpdate(passenger);
        return passenger;
    }

    @PostMapping("/api/passenger/delete")
    public void delete(@RequestBody Passenger passenger) throws Exception {
        passengerService.deleteById(passenger.getPaid());
    }
    @CrossOrigin
    @PostMapping("/api/passengers/search")
    public List<Passenger> searchResult(@RequestBody Passenger s) throws Exception {
        // 关键字为空时查询所有员工
        System.out.println("1"+s.getPaname());
        if ("null".equals(s.getPaname())) {
            return passengerService.list();
        } else {
            return passengerService.Search(s.getPaname());
        }
    }
}
