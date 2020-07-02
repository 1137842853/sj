package com.evan.sj.controller;

import com.evan.sj.pojo.Room;
import com.evan.sj.pojo.Search;
import com.evan.sj.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/api/rooms")
    public List<Room> list() throws Exception {
        return roomService.list();
    }

    @PostMapping("/api/rooms")
    public Room addOrUpdate(@RequestBody Room room) throws Exception {
        roomService.addOrUpdate(room);
        System.out.println( "1类型编号:" + room.getRoomType().getRtid()+ "类型编号:" + room.getRoomname());
        return room;
    }

    @PostMapping("/api/rooms/delete")
    public void delete(@RequestBody Room room) throws Exception {
        roomService.deleteById(room.getRoomid());
    }


    @GetMapping("/api/roomtypes/{rtid}/rooms")
    public List<Room> listByRoomType(@PathVariable("rtid") int rtid) throws Exception {
        if (0 != rtid) {
            return roomService.listByRoomType(rtid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @PostMapping("/api/rooms/search")
    public List<Room> searchResult(@RequestBody Search s) throws Exception {
        // 关键字为空时查询所有客房
        if ("null".equals(s.getKeywords())) {
            return roomService.list();
        } else {
            return roomService.Search(s.getKeywords());
        }
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
    @PostMapping("api/roomimages")
    public String roomimageUpload(MultipartFile file) throws Exception {
        String folder = "E:/workspace/image";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
