package com.evan.sj.dao;

import com.evan.sj.pojo.Announce;
import com.evan.sj.pojo.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceDAO extends JpaRepository <Announce, Integer> {
}
