//package com.saku.onlineprototype.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.saku.onlineprototype.dto.CustomPrinciple;
//import com.saku.onlineprototype.dto.TokenConfiguration;
//import com.saku.onlineprototype.dto.UserDto;
//import com.saku.onlineprototype.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Map;
//
//@Component
//@RequiredArgsConstructor
//public class JwtService {
//    private final UserService userService;
//    private final TokenConfiguration tokenConfiguration;
//
//    public String getAccessToken(String issuer, String username) {
//        Algorithm algorithm = Algorithm.HMAC256(tokenConfiguration.getSecretKey().getBytes());
//        UserDto userInfo = userService.getUserInfo(username);
//        return JWT.create()
//                .withSubject(userInfo.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + (tokenConfiguration.getAccessTimeout() * 60 * 1000)))
//                .withIssuer(issuer)
//                .withClaim(TokenConfiguration.ROLES, Arrays.asList("ROLE_USER"))
//                .withClaim(TokenConfiguration.USER_INFO, new ObjectMapper().convertValue(userInfo, Map.class))
//                .sign(algorithm);
//    }
//
//    public String getRefreshToken(String issuer, String username) {
//        Algorithm algorithm = Algorithm.HMAC256(tokenConfiguration.getSecretKey().getBytes());
//        return JWT.create()
//                .withSubject(username)
//                .withExpiresAt(new Date(System.currentTimeMillis() + (tokenConfiguration.getRefreshTimeout() * 60 * 1000)))
//                .withIssuer(issuer)
//                .withClaim(TokenConfiguration.ROLES, Arrays.asList("ROLE_USER"))
//                .sign(algorithm);
//    }
//
//    public String getUsername(String token) {
//        Algorithm algorithm = Algorithm.HMAC256(tokenConfiguration.getSecretKey().getBytes());
//        JWTVerifier verifier = JWT.require(algorithm).build();
//        DecodedJWT decodedJWT = verifier.verify(token);
//        return decodedJWT.getSubject();
//    }
//
//    public CustomPrinciple getPrinciple(String accessToken) {
//        Algorithm algorithm = Algorithm.HMAC256(tokenConfiguration.getSecretKey().getBytes());
//        JWTVerifier verifier = JWT.require(algorithm).build();
//        DecodedJWT decodedJWT = verifier.verify(accessToken);
//        String username = decodedJWT.getSubject();
//        Claim claim = decodedJWT.getClaim(TokenConfiguration.USER_INFO);
//        UserDto userDto = claim.as(UserDto.class);
//        return new CustomPrinciple()
//                .setUserId(Long.valueOf(userDto.getId()))
//                .setUsername(userDto.getUsername())
//                .setLang(userDto.getLang());
//    }
//
//}
//
