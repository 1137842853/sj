package com.evan.sj.controller;

import com.evan.sj.pojo.Corder;
import com.evan.sj.pojo.Passenger;
import com.evan.sj.service.CorderService;
import com.evan.sj.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CorderController {
    @Autowired
    CorderService corderService;

    @GetMapping("/api/corders")
    public List<Corder> list() throws Exception {
        //System.out.println("返回"+corderService.list().get(0));
        return corderService.list();
    }

    @PostMapping("/api/corders")
    public Corder addOrUpdate(@RequestBody Corder corder) throws Exception {
        corderService.addOrUpdate(corder);
        return corder;
    }

    @PostMapping("/api/corders/delete")
    public void delete(@RequestBody Corder corder) throws Exception {
        corderService.deleteById(corder.getCorid());
    }
    @PostMapping("/api/corders/search")
    public List<Corder> searchResult(@RequestBody Corder s) throws Exception {
        // 关键字为空时查询所有员工
        System.out.println("1"+s.getCorstate());
        if ("null".equals(s.getCorstate())) {
            return corderService.list();
        } else {
            return corderService.Search(s.getCorstate());
        }
    }

}
