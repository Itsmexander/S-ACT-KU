package com.saku.onlineprototype.repository;


import com.saku.onlineprototype.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,String> {
    Optional<Activity> searchByActivityID(String activityID);
}