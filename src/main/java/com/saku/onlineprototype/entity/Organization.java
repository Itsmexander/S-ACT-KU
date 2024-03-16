package com.saku.onlineprototype.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Organization")
public class Organization {
    @Id
    @Column(name = "OrgID")
    private String orgID;
    @Column(name = "Org_Type")
    private String orgType;
    @Column(name = "orgnameTH")
    private String orgNameTH;
    @Column(name = "orgnameEN")
    private String orgNameEN;
    @Column(name = "org_Head_Name")
    private String orgHeadName;
    @Column(name = "org_Sec_Name")
    private String orgSecName;
    @Column(name = "org_Avs_Name")
    private String orgAvsName;
    @Column(name = "Email")
    private String email;
    @Column(name = "telNO")
    private String telNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus")
    private Campus campus;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "users",nullable = false)
    private List<User> userList;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Org_Activity_List")
    private List<Activity> activityList;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Approved_Activity_List")
    private List<Activity> approvedActivityList;
}
