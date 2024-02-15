package com.saku.onlineprototype.repository;

import com.saku.onlineprototype.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUID(String uid);
}
