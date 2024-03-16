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
@Entity(name = "campus")
public class Campus {
    @Id
    @Column(name = "campusID")
    private int campusID;
    @Column(name = "campus_Name")
    private String campusName;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgs",nullable = false)
    private List<Organization> organizationList;
}
