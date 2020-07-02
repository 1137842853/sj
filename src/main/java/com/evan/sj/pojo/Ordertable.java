package com.evan.sj.pojo;

import com.evan.sj.datef.MyDateFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "ordertable")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Ordertable {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "orid")
//    int orid;
//    int ostaid;
//
//    public int getOrid() {
//        return orid;
//    }
//
//    public void setOrid(int orid) {
//        this.orid = orid;
//    }
//
//    public int getOstaid() {
//        return ostaid;
//    }
//
//    public void setOstaid(int ostaid) {
//        this.ostaid = ostaid;
//    }
//
//    public int getOpaid() {
//        return opaid;
//    }
//
//    public void setOpaid(int opaid) {
//        this.opaid = opaid;
//    }
//
//    public int getOroomid() {
//        return oroomid;
//    }
//
//    public void setOroomid(int oroomid) {
//        this.oroomid = oroomid;
//    }
//
////    public DateTime getOrftime() {
////        return orftime;
////    }
////
////    public void setOrftime(DateTime orftime) {
////        this.orftime = orftime;
////    }
//
//    public String getOrstate() {
//        return orstate;
//    }
//
//    public void setOrstate(String orstate) {
//        this.orstate = orstate;
//    }
//
//    int opaid;
//    int oroomid;
//   // DateTime orftime;
//    String orstate;
//
////    @ManyToOne
////    @JoinColumn(name="staid")
////    private Staff staff;
////
////    @ManyToOne
////    @JoinColumn(name="paid")
////    private Passenger passenger;
////
////    @ManyToOne
////    @JoinColumn(name="roomid")
////    private Room room;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orid")
    int orid;

    public int getOrid() {
        return orid;
    }

    public void setOrid(int orid) {
        this.orid = orid;
    }


    public String getOrstate() {
        return orstate;
    }

    public void setOrstate(String orstate) {
        this.orstate = orstate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getOrftime() {
        return orftime;
    }

    public void setOrftime(Date orftime) {
        this.orftime = orftime;
    }

    //日期格式转换
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    //@DateTimeFormat(pattern="yyyy-MM-dd")
            Date orftime;

    String orstate;

    @ManyToOne
    @JoinColumn(name = "ostaid")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "opaid")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "oroomid")
    private Room room;
}
