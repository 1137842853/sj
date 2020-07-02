package com.evan.sj.service;

import com.evan.sj.dao.AnnounceDAO;
import com.evan.sj.dao.PassengerDAO;
import com.evan.sj.pojo.Announce;
import com.evan.sj.pojo.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceService {
    @Autowired
    AnnounceDAO announceDAO;

    public List<Announce> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "nid");
        return announceDAO.findAll(sort);
    }

    public Page<Announce> pagelist() {
        Sort sort = new Sort(Sort.Direction.DESC, "nid");
        Pageable p = new PageRequest(0,5,sort);
        return announceDAO.findAll(p);
    }

    public void addOrUpdate(Announce announce) {
        announceDAO.save(announce);
    }

    public void deleteById(int nid) {
        announceDAO.deleteById(nid);
    }
}
