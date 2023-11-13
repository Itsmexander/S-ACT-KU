package com.saku.onlineprototype.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Advisor")
public class Advisor {
    //รหัสระบุตัวตนของอาจารย์ เช่น fscipkw
    @Id
    @Column(name = "ID")
    private String id;
    //
    @Column(name = "name")
    private String name;
    //
    @Column(name = "surname")
    private String surname;
    //
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "IS_ACTIVE")
    private boolean isActive = false;
    @Column(name = "IS_SUSPENDED")
    private boolean isSuspended = false;
    @Column(name = "VERSION")
    private int version;
    @CreatedDate
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;
}
