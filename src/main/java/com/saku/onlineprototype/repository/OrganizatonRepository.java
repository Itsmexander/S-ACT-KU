package com.saku.onlineprototype.repository;

import com.saku.onlineprototype.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizatonRepository extends JpaRepository<Organization,String> {
    Optional<Organization> findByCampusID(int campusID);
    Optional<Organization> findByOrgID(int orgID);
    Optional<Organization> findByOrgHeadName(String orgHeadName);
    Optional<Organization> findByOrgAvsName(String orgAvsName);
    Optional<Organization> findByOrgSecName(String orgSecName);
    Optional<Organization> findByOrgName(String orgName);
    Optional<Organization> findByOrgNameEN(String orgNameEN);
}
