package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.saku.onlineprototype.Enum.Faculty;
import com.saku.onlineprototype.Enum.Position;
import com.saku.onlineprototype.Enum.Role;
import com.saku.onlineprototype.entity.Organization;
import com.saku.onlineprototype.entity.User;
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
public class UserResponse {
    private String uID;
    private String password;
    private String name;
    private String telNo;
    private LocalDateTime createDate;
    private LocalDateTime lastupdatetimestamp;
    private Role role;
    private Faculty faculty;
    private Organization org;
    private Position position;


    public static UserResponse from(User user){
        return new UserResponse()
                .setUID(user.getUid())
                .setName(user.getName())
                .setPassword(user.getPassword())
                .setTelNo(user.getTelNo())
                .setCreateDate(user.getCreateDate())
                .setLastupdatetimestamp(user.getLastupdatetimestamp())
                .setRole(user.getRole())
                .setFaculty(user.getFaculty())
                .setOrg(user.getOrg())
                .setPosition(user.getPosition());
    }
}
