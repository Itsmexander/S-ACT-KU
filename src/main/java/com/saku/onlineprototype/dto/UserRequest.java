package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.saku.onlineprototype.Enum.Faculty;
import com.saku.onlineprototype.Enum.Role;
import com.saku.onlineprototype.entity.Organization;
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
    private String uID;
    private String password;
    private String name;
    private String telNo;
    private LocalDateTime createDate;
    private LocalDateTime lastupdatetimestamp;
    private Role role;
    private Faculty faculty;
    private Organization org;

}
