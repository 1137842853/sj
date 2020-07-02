package com.evan.sj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "corder")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Corder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corid")
    int corid;




    @ManyToOne
    @JoinColumn(name="staid")
    private Staff staff;


    @ManyToOne
    @JoinColumn(name="paid")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name="roomid")
    private Room room;

    public int getCorid() {
        return corid;
    }

    public void setCorid(int corid) {
        this.corid = corid;
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

    public Date getCorltime() {
        return corltime;
    }

    public void setCorltime(Date corltime) {
        this.corltime = corltime;
    }

    public String getCorstate() {
        return corstate;
    }

    public void setCorstate(String corstate) {
        this.corstate = corstate;
    }

    //日期格式转换
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    //@DateTimeFormat(pattern="yyyy-MM-dd")
            Date corltime;
    String corstate;

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    double cprice;


}
