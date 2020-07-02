package com.evan.sj.controller;

import com.evan.sj.pojo.Announce;
import com.evan.sj.pojo.Passenger;
import com.evan.sj.service.AnnounceService;
import com.evan.sj.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnounceController {
    @Autowired
    AnnounceService announceService;

    @GetMapping("/api/announces")
    public List<Announce> list() throws Exception {
        return announceService.list();
    }

    @GetMapping("/api/pageannounces")
    public List<Announce> pagelist() throws Exception {
        return announceService.pagelist().getContent();
    }

    @PostMapping("/api/announces")
    public Announce addOrUpdate(@RequestBody Announce announce) throws Exception {
        announceService.addOrUpdate(announce);
        return announce;
    }

    @PostMapping("/api/announces/delete")
    public void delete(@RequestBody Announce announce) throws Exception {
        announceService.deleteById(announce.getNid());
    }
}
