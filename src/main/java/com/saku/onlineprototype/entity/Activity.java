package com.saku.onlineprototype.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "activity")
public class Activity {
    @Id
    @Column(name = "ActivityID")
    private String activityID;
    @Column(name = "ProjectNameTH")
    private String projNameTH;
    @Column(name = "ProjectNameEN")
    private String projNameEN;
    @Column(name = "OrgType")
    private String orgType;
    @Column(name = "OrgName")
    private String orgName;
    @Column(name = "ActivityStartDateTime")
    private LocalDateTime activityStartDateTime;
    @Column(name = "ActivityEndDateTime")
    private LocalDateTime activityEndDateTime;
    @Column(name = "ActivityLocation")
    private String activityLocation;
    @Column(name = "ActivityDescription",length = 1000)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String activityDescription;
    @Column(name = "AllocatedMoney(FY)")
    private double allocatedMoneyFY;
    @Column(name = "AllocatedMoney(Addition)")
    private double allocatedMoneyAddition;
    @Column(name = "AllocatedMoney(Ex)")
    private double allocatedMoneyEx;
    @Column(name = "UsedAllocate")
    private double useAllocate;
    @Column(name = "StaffTargetNum")
    private int staffTargetNum;
    @Column(name = "AttendTargetNum")
    private int attendTargetNum;
    @Column(name = "StaffAttendedNum")
    private int staffAttendedNum;
    @Column(name = "AttendNum")
    private int attendedNum;
    @Column(name = "StaffAttendedtPerc")
    private double staffAttendedPerc;
    @Column(name = "AttendPerc")
    private double attendedPerc;
    @Column(name = "StaffApproveRate")
    private double staffApproveRate;
    @Column(name = "AttendedApproveRate")
    private double attendedApproveRate;
    @Column(name = "ActivityHour")
    private int activityHour;
    @Column(name = "IDKUType")
    private String idkuType;
    @Column(name = "TQFType")
    private String tqfType;
    @Column(name = "SDGs")
    private String sdgTypes;
    @Column(name = "KingsPhilosophyType")
    private String kingPhilosophyType;
}