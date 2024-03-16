package com.saku.onlineprototype.entity;

import jakarta.persistence.*;
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
    @Column(name = "status")
    private String status;
    @Column(name = "Project_NameTH")
    private String projNameTH;
    @Column(name = "Project_NameEN")
    private String projNameEN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org",nullable = false)
    private Organization organization;

//    @Column(name = "Org_Type")
//    private String orgType;
//    @Column(name = "Org_Name")
//    private String orgName;

    @Column(name = "Activity_Start_Date_Time")
    private LocalDateTime activityStartDateTime;
    @Column(name = "Activity_End_Date_Time")
    private LocalDateTime activityEndDateTime;
    @Column(name = "Activity_Location")
    private String activityLocation;
    @Column(name = "Activity_Description",length = 1000)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String activityDescription;

    @Column(name = "Allocated_Money(FY)")
    private double allocatedMoneyFY;
    @Column(name = "Allocated_Money(Addition)")
    private double allocatedMoneyAddition;
    @Column(name = "Allocated_Money(Ex)")
    private double allocatedMoneyEx;
    @Column(name = "Used_Allocate")
    private double usedAllocate;

    @Column(name = "Staff_Target_Num")
    private int staffTargetNum;
    @Column(name = "Attend_Target_Num")
    private int attendTargetNum;
    @Column(name = "Staff_Attended_Num")
    private int staffAttendedNum;
    @Column(name = "Attend_Num")
    private int attendedNum;
    @Column(name = "Staff_Attended_Perc")
    private double staffAttendedPerc;
    @Column(name = "Attend_Perc")
    private double attendedPerc;
    @Column(name = "Staff_Approve_Rate")
    private double staffApproveRate;
    @Column(name = "Attended_Approve_Rate")
    private double attendedApproveRate;

    @Column(name = "Activity_Hour")
    private int activityHour;
    @Column(name = "IDKUType")
    private String idkuType;
    @Column(name = "TQFType")
    private String tqfType;
    @Column(name = "SDGs")
    private String sdgTypes;
    @Column(name = "Kings_Philosophy_Type")
    private String kingPhilosophyType;
}