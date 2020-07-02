package com.evan.sj.dao;

import com.evan.sj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {
        User findByUsername(String username);
        List<User> findAllByUsernameLike(String keyword1);
        User getByUsernameAndPassword(String username,String password);
}
