package com.evan.sj.controller;

import com.evan.sj.pojo.Datas;
import com.evan.sj.pojo.Ordertable;
import com.evan.sj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/api/orders")
    public List<Ordertable> list() throws Exception {
        return orderService.list();
    }
    @GetMapping("/api/tborders")
    public List<Datas> tblist() throws Exception {
        //System.out.println(orderService.tblist());
        return orderService.tblist();
    }
    @GetMapping("/api/tborders1")
    public List<Map<String, Datas>> tblist1() throws Exception {
        System.out.println(orderService.tblist1());
        return orderService.tblist1();
    }
    @GetMapping("/api/tborders2")
    public List<Map<String, Datas>> tblist2() throws Exception {
       System.out.println(orderService.tblist2());
        return orderService.tblist2();
    }
    @GetMapping("/api/ordersnum")
    public int ordersnum() throws Exception {
        return orderService.ordersnum();
    }

    @PostMapping("/api/orders")
    public Ordertable addOrUpdate(@RequestBody Ordertable ordertable) throws Exception {
        orderService.addOrUpdate(ordertable);
        System.out.println();
        return ordertable;
    }


    @PostMapping("/api/orders/delete")
    public void delete(@RequestBody Ordertable ordertable) throws Exception {
        orderService.deleteById(ordertable.getOrid());
    }
}
