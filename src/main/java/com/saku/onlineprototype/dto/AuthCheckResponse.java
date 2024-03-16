package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.saku.onlineprototype.entity.Role;
import com.saku.onlineprototype.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthCheckResponse {
    private String uid;

    public static UserResponse from(User user){
        return new UserResponse()
                .setUid(user.getUid())
                .setName(user.getName())
                .setTelNo(user.getTelNo())
                .setCreateDate(user.getCreateDate())
                .setLastUpdateTimestamp(user.getLastUpdateTimestamp())
                .setRole((Role)user.getRole())
                .setFaculty(user.getFaculty())
                .setOrg(user.getOrg())
                .setPosition(user.getPosition());
    }
}
