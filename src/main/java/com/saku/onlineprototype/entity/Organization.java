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
    @Column(name = "orgnameTH")
    private String orgNameTH;
    @Column(name = "orgnameEN")
    private String orgNameEN;
    @Column(name = "orgHeadName")
    private String orgHeadName;
    @Column(name = "orgSecName")
    private String orgSecName;
    @Column(name = "orgAvsName")
    private String orgAvsName;
    @Column(name = "Email")
    private String email;
    @Column(name = "telNO")
    private String telNo;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "users",nullable = false)
    private List<User> userList;
}
