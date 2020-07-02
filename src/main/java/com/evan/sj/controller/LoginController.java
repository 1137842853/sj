package com.evan.sj.controller;

import com.evan.sj.pojo.Staff;
import com.evan.sj.pojo.User;
import com.evan.sj.result.Result;
import com.evan.sj.result.ResultFactory;
import com.evan.sj.service.StaffService;
import com.evan.sj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    StaffService staffService;

//    @CrossOrigin
//    @PostMapping(value = "/api/adminlogin")
//    public Result adminlogin(@RequestBody User requestUser, HttpSession session) {
//        String username = requestUser.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//        System.out.println(1 + requestUser.getUsername());
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
//        usernamePasswordToken.setRememberMe(true);
//        try {
//            session.setAttribute("user1", username);
//            subject.login(usernamePasswordToken);
//            //  System.out.println("1" + subject.isRemembered());
//            // System.out.println(subject.isAuthenticated());
//            return ResultFactory.buildSuccessResult(username);
//        } catch (IncorrectCredentialsException e) {
//            return ResultFactory.buildFailResult("密码错误");
//        } catch (UnknownAccountException e) {
//            return ResultFactory.buildFailResult("账号不存在");
//        }
//    }
    @CrossOrigin
    @PostMapping(value = "/api/adminlogin")
    public Result adminlogin(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();
        User u = userService.getByName(username);
        String oldhashpassword = userService.getByName(username).getPassword();
        //加密
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        //比较密码判断登录
        boolean f = bcryptPasswordEncoder.matches(password,oldhashpassword);
        if(f == true){
            System.out.println("加密密码"+u.getPassword());
            session.setAttribute("role1", requestUser.getArole());
            session.setAttribute("user1", u);
            return ResultFactory.buildSuccessResult(username);
        }
        else{return ResultFactory.buildFailResult("密码错误");}
    }

    @CrossOrigin
    @PostMapping(value = "/api/stafflogin")
    public Result stafflogin(@RequestBody Staff requestStaff, HttpSession session) {
        try {
            String username = requestStaff.getStausername();
            username = HtmlUtils.htmlEscape(username);
            String password = requestStaff.getStapassword();
            Staff s = staffService.getByName(username);
            String oldhashpassword = staffService.getByName(username).getStapassword();
            //加密
            BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
            //比较密码判断登录
            boolean f = bcryptPasswordEncoder.matches(password,oldhashpassword);
            System.out.println(f);
            if(f == true){
                System.out.println("加密密码"+s.getStapassword());
                // session.setAttribute("user1", username);
                session.setAttribute("role1", requestStaff.getSrole());
                session.setAttribute("staff1", s);
                 return ResultFactory.buildSuccessResult(username);
            }else if(f == false){
                return ResultFactory.buildFailResult("失败")  ;
            }
            return ResultFactory.buildFailResult("失败")  ;
        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在");
        }
    }


    @CrossOrigin
    @GetMapping(value = "/api/loginsendname")
    public Object Userreturn(HttpSession session) {
        User u = (User)session.getAttribute("user");
        System.out.println("session"+u.getUsername());
//        if (session.getAttribute("user").toString() == null) {
//            System.out.println("传递的User为空");
//        }
//        System.out.println(session.getAttribute("user1").toString());
        return session.getAttribute("user1");
    }

    @CrossOrigin
    @GetMapping(value = "/api/loginsendrole")
    public Object sendrole(HttpSession session) {
        if (session.getAttribute("role1").toString() == null) {
            System.out.println("传递的Role为空");
        }
        return session.getAttribute("role1");
    }

    @CrossOrigin
    @GetMapping(value = "/api/loginuser")
    public User Userreturn1(HttpSession session, User u) {
        User u1;

         u = (User)session.getAttribute("user1");
         u1 = userService.getByName(u.getUsername());
//        String uname = session.getAttribute("user1").toString();
//        String role = session.getAttribute("role1").toString();
//        if (uname == null) {
//            System.out.println("传递的User为空");
//        }
//        if(role == "admin"){
//            u = userService.getByName(uname);
//           System.out.println('1' + u.getId());
//            return u;
//        }
        return u1;
    }
    @CrossOrigin
    @GetMapping(value = "/api/loginstaff")
    public Staff Userreturn1(HttpSession session, Staff s) {
        Staff s1;
        s = (Staff)session.getAttribute("staff1");
        s1 = staffService.getByName(s.getStausername());

//        String uname = session.getAttribute("user1").toString();
//        String role = session.getAttribute("role1").toString();
//        if (uname == null) {
//            System.out.println("传递的Staff为空");
//        }
//        if(role == "staff"){
//            s = staffService.getByName(uname);
//            System.out.println('2' + s.getStaname());
//        }
        System.out.println("session" + s1.getStaname());
        return s1;
    }
}
