package com.saku.onlineprototype.controller;

import com.saku.onlineprototype.dto.OrganizationRequest;
import com.saku.onlineprototype.dto.OrganizationResponse;
import com.saku.onlineprototype.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping("/organization/{orgID}")
    public ResponseEntity<OrganizationResponse> getOrganization(@PathVariable String orgID){
        OrganizationResponse response = organizationService.getOrganization(orgID);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/organization")
    public ResponseEntity<OrganizationResponse> createOrganization(@RequestBody OrganizationRequest request){
        OrganizationResponse response = organizationService.createOrganization(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/organization/{orgID}")
    public ResponseEntity<OrganizationResponse> updateOrganization(@PathVariable String orgID,
                                                                   @RequestBody OrganizationRequest request){
        OrganizationResponse response = organizationService.updateOrganization(orgID, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
