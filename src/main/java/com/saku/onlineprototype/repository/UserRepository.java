package com.saku.onlineprototype.repository;

import com.saku.onlineprototype.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUid(String uid);
}
