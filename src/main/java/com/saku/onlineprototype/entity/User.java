package com.saku.onlineprototype.entity;

//import com.saku.onlineprototype.Enum.Faculty;
import com.saku.onlineprototype.Enum.Position;
import jakarta.persistence.*;
//    TODO: lastUpdateBy,lastUpdateTimestamp
//import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
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
    @Column(name = "year")
    private int year;
    @Column(name = "tel_no")
    private String telNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty")
    private Faculty faculty;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus")
    private Campus campus;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "Last_Update_Timestamp")
    private String lastUpdateTimestamp;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<Role> role;
    //    @Enumerated(EnumType.STRING)
    //    @Column(name= "role")
    //    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Org",nullable = false)
    private Organization org;
    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

//    public boolean isPresent() {
//    }
//    @LastModifiedDate
//    @Column(name = "LastModifiedTimeStamp")
//    public LocalDateTime lastUpdateTimestamp;
//    @LastModifiedBy
//    @Column(name = "LastModifiedBy")
//    public String lastUpdateBy;
//    public User(String uID, String name, String telNo, String accountType) {
//    }
}