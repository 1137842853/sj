package com.evan.sj.dao;

import com.evan.sj.pojo.Staff;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDAO extends JpaRepository<Staff,Integer> {
  Staff findByStausername(String username);
  List<Staff> findAllByStanameLike(String keyword1);

  @Modifying
  @Query("update Staff s set s.staname = :staname,s.simage = :simage"
          + " where s.staid = :staid")
  public int updateStaff(@Param("staname")String staname, @Param("simage")String simage, @Param("staid")int staid);

}
