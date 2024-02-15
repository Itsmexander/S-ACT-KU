package com.saku.onlineprototype.repository;

import com.saku.onlineprototype.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,String> {
}
