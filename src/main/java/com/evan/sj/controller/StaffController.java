package com.evan.sj.controller;

import com.evan.sj.pojo.Search;
import com.evan.sj.pojo.Staff;
import com.evan.sj.result.Result;
import com.evan.sj.result.ResultFactory;
import com.evan.sj.service.StaffS;
import com.evan.sj.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    StaffService staffService;

    @Autowired
    private StaffS staffser;

    @GetMapping("/api/staffs")
    public List<Staff> list() throws Exception {
       // System.out.println(staffService.list());
        return staffService.list();
    }

    @PostMapping("/api/staffs")
    public Staff addOrUpdate(@RequestBody Staff staff) throws Exception {
        staffService.addOrUpdate(staff);
        return staff;
    }

    //    @PostMapping("/api/staffcmes")
//    public Result changemes(@RequestBody Staff staff) {
//        int status = staffService.changemes(staff);
//        switch (status) {
//            case 0:
//                return ResultFactory.buildFailResult("上传的关键字为空");
//            case 1:
//                return ResultFactory.buildSuccessResult("修改成功");
//            case 2:
//                return ResultFactory.buildFailResult("修改失败");
//        }
//        return ResultFactory.buildFailResult("未知错误");
//    }
    @PostMapping("/api/staffcmes")
    public Result changemes(@RequestBody Staff staff) {
        int status = staffser.updateStaff(staff.getStaname(),staff.getSimage(),staff.getStaid());
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("上传的关键字为空");
            case 1:
                return ResultFactory.buildSuccessResult("修改成功");
            case 2:
                return ResultFactory.buildFailResult("修改失败");
        }
        return ResultFactory.buildFailResult("未知错误");
    }


    @PostMapping("/api/staffs/delete")
    public void delete(@RequestBody Staff staff) throws Exception {
        staffService.deleteById(staff.getStaid());
    }

    //    修改密码
    @CrossOrigin
    @PostMapping("api/staffcgps")
    public Result changeps(@RequestBody Staff staff) {
        int status = staffService.changeps(staff);
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
//    @PostMapping("/api/staffs/search")
//    public List<Staff> searchResult(@RequestBody Search s) throws Exception {
//        // 关键字为空时查询所有员工
//        if ("null".equals(s.getKeywords())) {
//            return staffService.list();
//        } else {
//            return staffService.Search(s.getKeywords());
//        }
//    }

    @PostMapping("/api/staffs/search")
    public List<Staff> searchResult(@RequestBody Staff s) throws Exception {
        // 关键字为空时查询所有员工
        System.out.println("1" + s.getStaname());
        if ("null".equals(s.getStaname())) {
            return staffService.list();
        } else {
            return staffService.Search(s.getStaname());
        }
    }
}
