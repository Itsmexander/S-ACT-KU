package com.saku.onlineprototype.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//    TODO: lastUpdateBy,lastUpdateTimestamp
//import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
//@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @Column(name = "UID")
    private String uID;
    @Column(name = "AccountType")
    private String accountType;
    @Column(name = "Name")
    private String name;
    @Column(name = "TelNo")
    private String telNo;
    @Column(name = "CreateDate")
    private LocalDateTime createDate;
//    @LastModifiedDate
//    @Column(name = "LastModifiedTimeStamp")
//    public LocalDateTime lastUpdateTimestamp;
//    @LastModifiedBy
//    @Column(name = "LastModifiedBy")
//    public String lastUpdateBy;
//    public User(String uID, String name, String telNo, String accountType) {
//    }
}