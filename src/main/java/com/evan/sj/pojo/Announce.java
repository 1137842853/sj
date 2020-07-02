package com.evan.sj.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.util.Date;

@Entity
@Table(name = "announce")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Announce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid")
    int nid;

    String nissure;
    //日期格式转换
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    //@DateTimeFormat(pattern="yyyy-MM-dd")
            Date nftime;

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getNissure() {
        return nissure;
    }

    public void setNissure(String nissure) {
        this.nissure = nissure;
    }

    public Date getNftime() {
        return nftime;
    }

    public void setNftime(Date nftime) {
        this.nftime = nftime;
    }

    public String getNconttext() {
        return nconttext;
    }

    public void setNconttext(String nconttext) {
        this.nconttext = nconttext;
    }

    String nconttext;
}
