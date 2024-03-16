package com.saku.onlineprototype.dto;


import com.saku.onlineprototype.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUid(String uid);
}