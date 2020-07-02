package com.evan.sj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "staff")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staid")
    int staid;

    public int getStaid() {
        return staid;
    }

    public void setStaid(int staid) {
        this.staid = staid;
    }

    public String getStausername() {
        return stausername;
    }

    public void setStausername(String stausername) {
        this.stausername = stausername;
    }

    public String getStapassword() {
        return stapassword;
    }

    public void setStapassword(String stapassword) {
        this.stapassword = stapassword;
    }

    public String getStaname() {
        return staname;
    }

    public void setStaname(String staname) {
        this.staname = staname;
    }

    String stausername;
    String stapassword;
    String staname;

    public String getStsalt() {
        return stsalt;
    }

    public void setStsalt(String stsalt) {
        this.stsalt = stsalt;
    }

    public String getStnewpassword() {
        return stnewpassword;
    }

    public void setStnewpassword(String stnewpassword) {
        this.stnewpassword = stnewpassword;
    }

    String stsalt;
    String stnewpassword;
    public String getSrole() {
        return srole;
    }

    public void setSrole(String srole) {
        this.srole = srole;
    }

    String srole;

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

    String simage;
}
