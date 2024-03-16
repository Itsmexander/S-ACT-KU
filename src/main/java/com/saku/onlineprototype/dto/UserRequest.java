package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.saku.onlineprototype.Enum.Faculty;
import com.saku.onlineprototype.Enum.Position;
import com.saku.onlineprototype.Enum.Role;
import com.saku.onlineprototype.entity.Campus;
import com.saku.onlineprototype.entity.Faculty;
import com.saku.onlineprototype.entity.Organization;
import com.saku.onlineprototype.entity.Schedule;
import jakarta.persistence.*;
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
public class UserRequest {
    private String uid;
    private String name;
    private int year;
    private String telNo;
    private Faculty faculty;
    private Campus campus;
    private String createDate;
    private String lastUpdateTimestamp;
    private Role role;
    private Organization org;
    private Position position;
    private String password;
}
