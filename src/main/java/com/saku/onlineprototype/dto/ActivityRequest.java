package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityRequest {

    private String activityID;
    private String status;
    private String projNameTH;
    private String projNameEN;
    private String orgType;
    private String orgName;
    private LocalDateTime activityStartDateTime;
    private LocalDateTime activityEndDateTime;
    private String activityLocation;
    private String activityDescription;
    private double allocatedMoneyFY;
    private double allocatedMoneyAddition;
    private double allocatedMoneyEx;
    private double usedAllocate;
    private int staffTargetNum;
    private int attendTargetNum;
    private int staffAttendedNum;
    private int attendedNum;
    private double staffAttendedPerc;
    private double attendedPerc;
    private double staffApproveRate;
    private double attendedApproveRate;
    private int activityHour;
    private String idkuType;
    private String tqfType;
    private String sdgTypes;
    private String kingPhilosophyType;
}
