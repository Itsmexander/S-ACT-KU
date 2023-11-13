package com.saku.onlineprototype.repository;

import com.saku.onlineprototype.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    Optional<Advisor> findAdvisorById(String id);
    Optional<Advisor> findAdvisorByName(String s);
    Optional<Advisor> findAdvisorBySurname(String s);
}
