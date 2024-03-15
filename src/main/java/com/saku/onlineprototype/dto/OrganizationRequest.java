package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.saku.onlineprototype.entity.Activity;
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
public class OrganizationRequest {
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
}
