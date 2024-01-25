package com.saku.onlineprototype.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
