package com.evan.sj.service;

import com.evan.sj.dao.OrderDAO;
import com.evan.sj.mapper.OrderMapper;
import com.evan.sj.pojo.Datas;
import com.evan.sj.pojo.Ordertable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderMapper orderMapper;

    public List<Ordertable> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "orid");
        return orderDAO.findAll(sort);
    }

    public List<Datas> tblist() {
        return orderMapper.get();
    }
    public List<Map<String, Datas>> tblist1() {
        return orderMapper.get1();
    }
    public List<Map<String, Datas>> tblist2() {
        return orderMapper.get2();
    }
    public void addOrUpdate(Ordertable ordertable) {
        orderDAO.save(ordertable);
    }

    public int ordersnum() {
        // Sort sort = new Sort(Sort.Direction.DESC,"rtid");
        return orderDAO.findAll().size();
    }
    public void deleteById(int orid) {
        orderDAO.deleteById(orid);
    }
//    public List<Room> listByRoomType(int rtid) {
//        RoomType roomType = roomTypeService.get(rtid);
//        Sort sort = new Sort(Sort.Direction.DESC, "tid");
//        return roomDAO.findAllByRoomType(roomType);
//    }
//
//    public List<Room> Search(String keywords) {
//        return roomDAO.findAllByRoomstateLikeOrRoomnameLike('%' + keywords + '%', '%' + keywords + '%');
//    }
}
