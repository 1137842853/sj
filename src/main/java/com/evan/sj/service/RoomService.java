package com.evan.sj.service;

import com.evan.sj.dao.RoomDAO;
import com.evan.sj.pojo.Room;
import com.evan.sj.pojo.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomDAO roomDAO;
    @Autowired
    RoomTypeService roomTypeService;

    public List<Room> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "roomid");
        return roomDAO.findAll(sort);
    }
    public int roomnum() {
        // Sort sort = new Sort(Sort.Direction.DESC,"rtid");
        return roomDAO.findAll().size();
    }

    public void addOrUpdate(Room room) {
        roomDAO.save(room);
    }
//    @Transactional
//    public void updateOne(Room room) {
//        roomDAO.updateOne(room.getRoomname(),room.getRoomdeposit(),room.getRoomstate(),room.getRoomimage(),room.getRoomid());
//    }
//    @Transactional
//    public void insertOne(Room room) {
//        roomDAO.insertOne1(room);
//    }
    public void deleteById(int roomid) {
        roomDAO.deleteById(roomid);
    }

    public List<Room> listByRoomType(int rrtid) {
        RoomType roomType = roomTypeService.get(rrtid);
        Sort sort = new Sort(Sort.Direction.ASC, "rtid");
        return roomDAO.findAllByRoomType(roomType);
    }

    public List<Room> Search(String keywords) {
        return roomDAO.findAllByRoomstateLikeOrRoomnameLike('%' + keywords + '%', '%' + keywords + '%');
    }
}
