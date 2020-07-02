package com.evan.sj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenController {
    @ResponseBody
    @GetMapping("/api/authentication")
    public String authentication(){
        return "身份认证成功";
    }
}
