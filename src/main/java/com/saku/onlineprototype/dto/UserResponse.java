package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String accountType;
    private String name;
    private String telNo;
    private LocalDateTime createDate;

    public static UserResponse from(User user){
        return new UserResponse()
                .setUID(user.getUid())
                .setName(user.getName())
                .setAccountType(user.getAccountType())
                .setTelNo(user.getTelNo())
                .setCreateDate(user.getCreateDate());
    }
}
