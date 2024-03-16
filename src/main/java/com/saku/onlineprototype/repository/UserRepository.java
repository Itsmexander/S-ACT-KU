package com.saku.onlineprototype.repository;

import com.saku.onlineprototype.entity.Role;
import com.saku.onlineprototype.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUid(String uid);
//    Optional<User> findByUid(String uid);
    Optional<User> findByRole(Role role);


//    Optional<User> findByCreateDateAfter(LocalDateTime dateTime);
//    Optional<User> findByCreateDateBefore(LocalDateTime dateTime);
//    Optional<User> findByCreateDateBetween(LocalDateTime dateTime,LocalDateTime dateTime2);
}