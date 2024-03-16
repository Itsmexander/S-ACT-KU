package com.saku.onlineprototype.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "scheduleID")
    private UUID scheduleUUID;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    private List<SubActivity> subActivityList;;
}
