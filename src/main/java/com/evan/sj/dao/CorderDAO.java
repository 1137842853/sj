package com.evan.sj.dao;

import com.evan.sj.pojo.Corder;
import com.evan.sj.pojo.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorderDAO extends JpaRepository <Corder, Integer> {
    List<Corder> findAllByCorstateLike(String keyword1);
}
