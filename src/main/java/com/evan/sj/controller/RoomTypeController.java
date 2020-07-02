package com.evan.sj.controller;

import com.evan.sj.pojo.Passenger;
import com.evan.sj.pojo.RoomType;
import com.evan.sj.service.PassengerService;
import com.evan.sj.service.RoomService;
import com.evan.sj.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomTypeController {
    @Autowired
    RoomTypeService roomTypeService;

    @Autowired
    RoomService roomService;

    @GetMapping("/api/roomtypes")
    public List<RoomType> list() throws Exception {
        return roomTypeService.list();
    }

    @GetMapping("/api/roomtypesnum")
    public int roomnum() throws Exception {
        return roomService.roomnum();
    }

    @PostMapping("/api/roomtypes")
    public RoomType addOrUpdate(@RequestBody RoomType roomType) throws Exception {
        roomTypeService.addOrUpdate(roomType);
        return roomType;
    }
    @CrossOrigin
    @PostMapping("/api/roomtypes/delete")
    public void delete(@RequestBody RoomType roomType) throws Exception {
        roomTypeService.deleteById(roomType.getRtid());
    }
}
