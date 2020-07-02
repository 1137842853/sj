package com.evan.sj.dao;

import com.evan.sj.pojo.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerDAO extends JpaRepository <Passenger, Integer> {
    List<Passenger> findAllByPanameLike(String keyword1);
}
