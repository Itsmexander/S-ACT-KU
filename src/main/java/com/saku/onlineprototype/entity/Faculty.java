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
@Entity(name = "faculty")
public class Faculty {
    @Id
    @Column(name = "facultyID")
    private String facultyID;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_in_fac",nullable = false)
    private List<User> userList;
}