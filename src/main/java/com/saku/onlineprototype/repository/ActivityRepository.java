package com.saku.onlineprototype.repository;


import com.saku.onlineprototype.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,String> {
}
