package com.evan.sj.service;

import com.evan.sj.dao.AnnounceDAO;
import com.evan.sj.dao.CorderDAO;
import com.evan.sj.pojo.Announce;
import com.evan.sj.pojo.Corder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorderService {
    @Autowired
    CorderDAO corderDAO;

    public List<Corder> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "corid");
        return corderDAO.findAll(sort);
    }

    public void addOrUpdate(Corder corder) {
        corderDAO.save(corder);
    }

    public void deleteById(int corid) {
        corderDAO.deleteById(corid);
    }

    public List<Corder> Search(String keywords) {
        return corderDAO.findAllByCorstateLike('%' + keywords + '%');
        //return staffDAO.findAllByStaname('%' + keywords + '%');
    }
}
