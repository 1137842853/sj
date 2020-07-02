package com.evan.sj.service;

import com.evan.sj.dao.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StaffSimpl implements StaffS {
    @Autowired
    StaffDAO staffDAO;

    @Transactional
    public int updateStaff(String staname,String simage,int staid)
    {
        return staffDAO.updateStaff(staname,simage,staid);
    }

}
