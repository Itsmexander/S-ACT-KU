package com.saku.onlineprototype.service;

import com.saku.onlineprototype.dto.OrganizationRequest;
import com.saku.onlineprototype.dto.OrganizationResponse;
import com.saku.onlineprototype.entity.Organization;
import com.saku.onlineprototype.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationResponse createOrganization(OrganizationRequest organizationRequest) {
        return null;
    }

    @Override
    public OrganizationResponse getOrganization(String orgID) {
        return null;
    }

    @Override
    public OrganizationResponse updateOrganization(String orgID, OrganizationRequest organizationRequest) {
        return null;
    }
    public List<Organization> getAllOrganiztions(){return organizationRepository.findAll();}
}