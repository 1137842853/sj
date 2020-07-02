package com.evan.sj.dao;

import com.evan.sj.pojo.Datas;
import com.evan.sj.pojo.Ordertable;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Ordertable,Integer> {
//    @Query(value = "select count(o.orid) AS data,o.staff.staid AS label FROM Ordertable  o GROUP BY o.staff.staid")
//    List<Datas> findmap();
//    @Query(value = "insert into ordertable(ostaid,opaid,oroomid,orftime,orstate) values(:#{#ordertable.ostaid},:#{#ordertable.opaid},:#{#ordertable.oroomid},:#{#ordertable.orftime},:#{#ordertable.orstate}) ", nativeQuery = true)
//    @Modifying
//    public void insertOne(@Param("ordertable") Ordertable ordertable);

//    @Query(value =  "select * from ordertb o where o.orid=:#{#ordertable.orid} ",nativeQuery = true)
//    public List<Ordertable> findByOrid(@Param("ordertable") Ordertable ordertable);
}
