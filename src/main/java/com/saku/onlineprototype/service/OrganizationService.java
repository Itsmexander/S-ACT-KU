package com.saku.onlineprototype.service;

import com.saku.onlineprototype.dto.OrganizationRequest;
import com.saku.onlineprototype.dto.OrganizationResponse;
import com.saku.onlineprototype.entity.Organization;
import com.saku.onlineprototype.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrganizationService {
    OrganizationResponse createOrganization(OrganizationRequest organizationRequest);
    OrganizationResponse getOrganization(String orgID);
    OrganizationResponse updateOrganization(String orgID, OrganizationRequest organizationRequest);
}
