package com.evan.sj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "roomtype")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rtid")
    int rtid;

    public int getRtid() {
        return rtid;
    }

    public void setRtid(int rtid) {
        this.rtid = rtid;
    }

    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname;
    }

    public Float getRtprice() {
        return rtprice;
    }

    public void setRtprice(Float rtprice) {
        this.rtprice = rtprice;
    }

    public int getRtnum() {
        return rtnum;
    }

    public void setRtnum(int rtnum) {
        this.rtnum = rtnum;
    }

    String rtname;
    Float rtprice;
    int rtnum;

}
