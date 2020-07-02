package com.evan.sj.service;

import com.evan.sj.dao.UserDAO;
import com.evan.sj.pojo.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import org.springframework.data.domain.Sort;
import org.jasypt.spring.security.PasswordEncoder;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<User> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return userDAO.findAll(sort);
    }

    public void addOrUpdate(User user) {
        userDAO.save(user);
    }

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    //根据账号查询管理员信息
    public List<User> Search(String keywords) {
        return userDAO.findAllByUsernameLike('%' + keywords + '%');
    }

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }


    public User get(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }

    public int changeps(User user) {
        String username = user.getUsername();
        //未加密的用于比较的旧密码
        String password = user.getPassword();
        //想改的新密码
        String newpassword = user.getNewpassword();
        //根据用户名获取旧的加密的密码
        String oldhashpassword = userDAO.findByUsername(username).getPassword();
        //System.out.println(hashPass);

        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密后的用于比较原密码
        String hashpassword = bcryptPasswordEncoder.encode(password);

        System.out.println("用户输入的旧"+hashpassword);
        System.out.println("旧"+oldhashpassword);

        boolean f = bcryptPasswordEncoder.matches(password,oldhashpassword);
        System.out.println(f);

        if (username.equals("") || password.equals("")) {
            return 0;
        }
        else if(f == true){
            user.setPassword(bcryptPasswordEncoder.encode(newpassword));
            user.setNewpassword(bcryptPasswordEncoder.encode(newpassword));
            userDAO.save(user);
            return 1;
        }
        else if(f == false){
            return 3;
        }
        return 2;
    }
    public int register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
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
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userDAO.save(user);
        return 1;
    }
//    public int register1(User user) {
//        String username = user.getUsername();
//        String password = user.getPassword();
//        username = HtmlUtils.htmlEscape(username);
//        user.setUsername(username);
//        if (username.equals("") || password.equals("")) {
//            return 0;
//        }
//
//        boolean exist = isExist(username);
//
//        if (exist) {
//            return 2;
//        }
//        // 默认生成 16 位盐
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//        int times = 2;
//        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
//
//        user.setSalt(salt);
//        user.setPassword(encodedPassword);
//        userDAO.save(user);
//        return 1;
//    }
}
