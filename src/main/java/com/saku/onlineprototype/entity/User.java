package com.saku.onlineprototype.entity;

import com.saku.onlineprototype.Enum.Faculty;
import com.saku.onlineprototype.Enum.Role;
import jakarta.persistence.*;
//    TODO: lastUpdateBy,lastUpdateTimestamp
//import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
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
    @Column(name = "uid")
    private String uid;
    @Column(name = "password")
    private String password;
    @Column(name = "Name")
    private String name;
    @Column(name = "TelNo")
    private String telNo;
    @Column(name = "CreateDate")
    private LocalDateTime createDate;
    @Column(name = "LastUpdateTimestamp")
    private LocalDateTime lastupdatetimestamp;
    @Enumerated(EnumType.STRING)
    @Column(name= "role")
    private Role role;
    @Enumerated(EnumType.STRING)
    @Column(name = "faculty")
    private Faculty faculty;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Org",nullable = false)
    private Organization org;
//    @LastModifiedDate
//    @Column(name = "LastModifiedTimeStamp")
//    public LocalDateTime lastUpdateTimestamp;
//    @LastModifiedBy
//    @Column(name = "LastModifiedBy")
//    public String lastUpdateBy;
//    public User(String uID, String name, String telNo, String accountType) {
//    }
}