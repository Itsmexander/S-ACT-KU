package com.saku.onlineprototype.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @Column(name = "UID")
    public String uID;
    @Column(name = "Name")
    public String name;
    @Column(name = "PhoneNum")
    public String telNo;
    @Column(name = "AccountType")
    public String accountType;
    @LastModifiedDate
    @Column(name = "LastModifedTimeStmp")
    public LocalDateTime lastUpdateTimestamp;
    @LastModifiedBy
    @Column(name = "LastModifiedBy")
    public String lastUpdateBy;

//    public User(String uID, String name, String telNo, String accountType) {
//    }
}