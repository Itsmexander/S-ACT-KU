package com.saku.onlineprototype.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TokenConfiguration {
    public static final String TOKEN_HEADER = "Application-Token";
    public static final String TOKEN_HEADER_START_WITH = "Bearer ";
    public static final String ACCESS_TOKEN = "accessToken";
    public static final String REFRESH_TOKEN = "refreshToken";
    public static final String USER_INFO = "userInfo";
    public static final String ROLES = "roles";
    private String secretKey;
    private int accessTimeout;
    private int refreshTimeout;
}
