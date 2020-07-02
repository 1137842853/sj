package com.evan.sj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paid")
    int paid;

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public String getPaname() {
        return paname;
    }

    public void setPaname(String paname) {
        this.paname = paname;
    }

    public String getPasex() {
        return pasex;
    }

    public void setPasex(String pasex) {
        this.pasex = pasex;
    }

    public String getPaidcard() {
        return paidcard;
    }

    public void setPaidcard(String paidcard) {
        this.paidcard = paidcard;
    }

    public String getPaphone() {
        return paphone;
    }

    public void setPaphone(String paphone) {
        this.paphone = paphone;
    }

    String paname;
    String pasex;
    String paidcard;
    String paphone;
}
