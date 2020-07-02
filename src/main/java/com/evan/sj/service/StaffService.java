package com.evan.sj.service;

import com.evan.sj.dao.StaffDAO;
import com.evan.sj.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    StaffDAO staffDAO;
    public List<Staff> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "staid");
        return staffDAO.findAll(sort);
    }
    public Staff getByName(String username) {
        return staffDAO.findByStausername(username);
    }
    public void addOrUpdate(Staff staff) {
        staffDAO.save(staff);
    }

    public void deleteById(int staid) {
        staffDAO.deleteById(staid);
    }

    public List<Staff> Search(String keywords) {
        return staffDAO.findAllByStanameLike('%' + keywords + '%');
        //return staffDAO.findAllByStaname('%' + keywords + '%');
    }
    public boolean isExist(String username) {
        Staff staff = getByName(username);
        return null != staff;
    }

    public int changeps(Staff staff) {
        String username = staff.getStausername();
        //未加密的用于比较的旧密码
        String password = staff.getStapassword();
        //想改的新密码
        String newpassword = staff.getStnewpassword();
        //根据用户名获取旧的加密的密码
        String oldhashpassword = staffDAO.findByStausername(username).getStapassword();
        //System.out.println(hashPass);

        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密后的用于比较原密码
        String hashpassword = bcryptPasswordEncoder.encode(password);

        boolean f = bcryptPasswordEncoder.matches(password,oldhashpassword);
        if (username.equals("") || password.equals("")) {
            return 0;
        }
        else if(f == true){
            staff.setStapassword(bcryptPasswordEncoder.encode(newpassword));
            staff.setStnewpassword(bcryptPasswordEncoder.encode(newpassword));
            staffDAO.save(staff);
            return 1;
        }else if(f == false){
            return 3;
        }
        return 2;
    }

    //修改员工信息
//    @Transactional
//    public int changemes(Staff staff) {
//        if (staff.getStaname().equals("") || staff.getStapassword().equals("")|| staff.getSrole().equals("")|| staff.getStaid() == 0) {
//            return 0;
//        }
//        else {
//            try {
//                staffDAO.updateStaff(staff.getStaname(),staff.getSimage(),staff.getStaid());
//                return 1;
//            }catch (Exception e) {
//            System.out.println(e.getMessage());}
//            return 2;
//        }
//    }
    public int register(Staff staff) {
        String username = staff.getStausername();
        String password = staff.getStapassword();
        username = HtmlUtils.htmlEscape(username);
        staff.setStausername(username);
        if (username.equals("") || password.equals("")) {
            return 0;
        }
        boolean exist = isExist(username);

        if (exist) {
            return 2;
        }
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密后的用于比较原密码
        String encodedPassword = bcryptPasswordEncoder.encode(password);
        String salt = BCrypt.gensalt().toString();
     //   staff.set(salt);
        staff.setStapassword(encodedPassword);
        staffDAO.save(staff);
        return 1;
    }
}
