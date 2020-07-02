package com.evan.sj.service;

import com.evan.sj.dao.RoomTypeDAO;
import com.evan.sj.pojo.Passenger;
import com.evan.sj.pojo.RoomType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {
    @Autowired
    RoomTypeDAO roomTypeDAO;

    public List<RoomType> list() {
        Sort sort = new Sort(Sort.Direction.ASC,"rtid");
        return roomTypeDAO.findAll(sort);
    }

    public void deleteById(int rtid) {
        roomTypeDAO.deleteById(rtid);
    }

    public RoomType get(int rtid) {
        RoomType c= roomTypeDAO.findById(rtid).orElse(null);
        return c;
    }
    public void addOrUpdate(RoomType roomType) {
        roomTypeDAO.save(roomType);
    }
}
