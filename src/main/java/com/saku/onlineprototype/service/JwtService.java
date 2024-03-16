package com.saku.onlineprototype.service;

//import com.saku.onlineprototype.dto.TokenConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final UserService userService;

    @Value("${jwt.secret.key}") private String secretKey;
    @Value("${jwt.expiration}") private Long expiration;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

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


}

