package com.evan.sj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "ordertable")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Order {
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

    public DateTime getOrftime() {
        return orftime;
    }

    public void setOrftime(DateTime orftime) {
        this.orftime = orftime;
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

    DateTime orftime;
    String orstate;

    @ManyToOne
    @JoinColumn(name="ostaid")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name="opaid")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name="oroomid")
    private Room room;

}
