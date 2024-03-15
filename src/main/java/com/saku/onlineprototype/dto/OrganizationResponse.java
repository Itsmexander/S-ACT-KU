package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.saku.onlineprototype.entity.Activity;
import com.saku.onlineprototype.entity.Organization;
import com.saku.onlineprototype.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationResponse {
    private String orgID;
    private String orgNameTH;
    private String orgNameEN;
    private String orgHeadName;
    private String orgSecName;
    private String orgAvsName;
    private String email;
    private String telNo;
    private List<User> userList;
    private List<Activity> activityList;
    private List<Activity> approvedActivityList;
    public static OrganizationResponse from(Organization organization){
        return new OrganizationResponse()
                .setOrgID(organization.getOrgID())
                .setOrgNameTH(organization.getOrgNameTH())
                .setOrgNameEN(organization.getOrgNameEN())
                .setOrgHeadName(organization.getOrgHeadName())
                .setOrgSecName(organization.getOrgSecName())
                .setOrgAvsName(organization.getOrgAvsName())
                .setEmail(organization.getEmail())
                .setTelNo(organization.getTelNo())
                .setUserList(organization.getUserList())
                .setActivityList(organization.getActivityList())
                .setApprovedActivityList(organization.getApprovedActivityList());
    }
}
