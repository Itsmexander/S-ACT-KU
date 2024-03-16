package com.saku.onlineprototype.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "subactivity")
public class SubActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subactivity_UUID")
    private UUID subactUUID;
    @Column(name = "subact_datetime")
    private LocalDateTime subActDateTime;
    @Column(name = "subact_desc")
    private String subActDesc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule")
    private Schedule schedule;
}