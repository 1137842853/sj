package com.evan.sj.service;

import com.evan.sj.dao.PassengerDAO;
import com.evan.sj.pojo.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerDAO passengerDAO;

    public List<Passenger> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "paid");
        return passengerDAO.findAll(sort);
    }
    public List<Passenger> Search(String keywords) {
        return passengerDAO.findAllByPanameLike('%' + keywords + '%');
        //return staffDAO.findAllByStaname('%' + keywords + '%');
    }
    public void addOrUpdate(Passenger passenger) {
        passengerDAO.save(passenger);
    }

    public void deleteById(int paid) {
        passengerDAO.deleteById(paid);
    }
}
