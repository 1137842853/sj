package com.evan.sj.controller;

import com.evan.sj.pojo.Staff;
import com.evan.sj.pojo.User;
import com.evan.sj.result.Result;
import com.evan.sj.result.ResultFactory;
import com.evan.sj.service.StaffService;
import com.evan.sj.service.UserService;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    StaffService staffService;

    @CrossOrigin
    @PostMapping("api/adminregister")
    public Result adminregister(@RequestBody User user) {
        int status = userService.register(user);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
    @CrossOrigin
    @PostMapping("api/staffregister")
    public Result staffregister(@RequestBody Staff staff) {
        int status = staffService.register(staff);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
}
