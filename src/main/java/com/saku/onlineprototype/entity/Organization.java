package com.saku.onlineprototype.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Organization")
public class Organization{
    // วิทยาเขต Ex. 1 = บางเขน, 2 = กำแพงแสน, 3 = ศรีราชา
    @Column(name = "CampusID")
    private int campusID;
    // รหัสหน่วยงาน(เฉพาะหน่วยงาน)
    @Column(name = "OrgID")
    private int orgID;
    // รหัสหน่วยงาน(รวมวิทยาเขต)
    @Id
    @Column(name = "combinedID")
    private String combinedID;
    // ชื่อชมรม
    @Column(name = "OrgName")
    private String orgName;
    // ชื่อชมรม(ภาษาอังกฤษ)
    @Column(name = "OrgNameEN")
    private String orgNameEN;
    // ชื่อประธานชมรม
    @Column(name = "OrgHeadName")
    private String orgHeadName;
    // ชื่อเหรัญญิก
    @Column(name = "OrgSecName")
    private String orgSecName;
    // ชื่ออาจารย์ที่ปรึกษาชมรม
    @Column(name = "OrgAvsName")
    private String orgAvsName;
}
