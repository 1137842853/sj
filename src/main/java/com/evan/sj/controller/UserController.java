package com.evan.sj.controller;

import com.evan.sj.pojo.Search;
import com.evan.sj.pojo.User;
import com.evan.sj.result.ResultFactory;
import com.evan.sj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.evan.sj.result.Result;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/users")
    public List<User> list() throws Exception {
        return userService.list();
    }

    @PostMapping("/api/users")
    public User addOrUpdate(@RequestBody User user) throws Exception {
        userService.addOrUpdate(user);
        System.out.println( "1类型编号:" + user.getUsername()+ "类型编号:" + user.getAimage());
        return user;
    }
//    @CrossOrigin
//    @PostMapping("/api/users/search1")
//    public List<User> searchResult(@RequestBody User s) throws Exception {
//        // 关键字为空时查询所有员工
//        if ("null".equals(s.getUsername())) {
//            return userService.list();
//        } else {
//            return userService.Search(s.getUsername());
//        }
//    }
    @CrossOrigin
    @PostMapping("/api/users/search")
    public List<User> searchResult(@RequestBody Search s) throws Exception {
        // 关键字为空时查询所有客房
        if ("null".equals(s.getKeywords())) {
            return userService.list();
        } else {
            return userService.Search(s.getKeywords());
        }
    }

//    修改密码
    @CrossOrigin
    @PostMapping("api/userscgps")
    public Result changeps(@RequestBody User user ) {
        int status = userService.changeps(user);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("修改成功");
            case 2:
                return ResultFactory.buildFailResult("修改失败");
            case 3:
                return ResultFactory.buildFailResult("输入原密码错误");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

    //生成指定长度随机字符串的代码
    public String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    //对文件的操作，对接收到的文件重命名，但保留原始的格式
    @CrossOrigin
    @PostMapping("api/adminimages")
    public String roomimageUpload(MultipartFile file) throws Exception {
        String folder = "E:\\workspace\\by-vue\\static\\assets\\img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "/static/assets/img/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
