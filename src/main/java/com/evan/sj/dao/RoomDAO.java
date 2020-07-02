package com.evan.sj.dao;
import com.evan.sj.pojo.Room;
import com.evan.sj.pojo.RoomType;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomDAO extends JpaRepository<Room,Integer> {
    List<Room> findAllByRoomType(RoomType roomType);
    List<Room> findAllByRoomstateLikeOrRoomnameLike(String keyword1, String keyword2);
//    @Query(value = "update room set roomname=?1,roomdeposit=?2,roomstate=?3,roomimage=?4 where roomid=?5 ", nativeQuery = true)
//    @Modifying
//    public void updateOne(String roomname,float roomdeposit,String roomstate,String roomimage,int roomid);
//
////    @Query(value = "update room set rtid=?1,roomname=?2,roomdeposit=?3,roomstate=?4,roomimage=?5 where roomid=?6 ", nativeQuery = true)
////    @Modifying
////    public void updateOne1(int rtid,String roomname,float roomdeposit,String roomstate,String roomimage,int roomid);
//
//    @Query(value = "insert into room(roomname,roomdeposit,roomstate,roomimage) values(:#{#room.roomname},:#{#room.roomdeposit},:#{#room.roomstate},:#{#room.roomimage}) ", nativeQuery = true)
//    @Modifying
//    public void insertOne(@Param("room") Room room);
//
//    @Query(value = "insert into room(rtid,roomname,roomdeposit,roomstate,roomimage) values(:#{#room.rmType.rtid},:#{#room.roomname},:#{#room.roomdeposit},:#{#room.roomstate},:#{#room.roomimage}) ", nativeQuery = true)
//    @Modifying
//    public void insertOne1(@Param("room") Room room);
//    @Transactional
////    @Modifying
////    @Query(value = "INSERT INTO room(rtid, roomname,roomdeposit,roomstate,roomimage) VALUES (:#{#room.rmType.tid}, :#{#room.roomname}, :#{#room.roomdeposit}, :#{#room.roomdstate}, :#{#room.roomimage})", nativeQuery = true)
////    int insert(@Param("room") Room room);

}

