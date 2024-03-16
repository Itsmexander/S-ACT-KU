//package com.saku.onlineprototype.filter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.saku.onlineprototype.dto.CustomPrinciple;
//import com.saku.onlineprototype.dto.TokenConfiguration;
//import com.saku.onlineprototype.service.JwtService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//
//import static java.util.Arrays.stream;
//import static org.springframework.http.HttpStatus.FORBIDDEN;
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@Slf4j
//public class CustomAuthorizationFilter extends OncePerRequestFilter {
//    private final TokenConfiguration tokenConfiguration;
//    private final JwtService jwtService;
//
//    public CustomAuthorizationFilter(TokenConfiguration tokenConfiguration, JwtService jwtService) {
//        this.tokenConfiguration = tokenConfiguration;
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (request.getServletPath().equals("/api/login") || request.getServletPath().equals("/api/token/refresh") || request.getServletPath().equals("/api/users")) {
//            filterChain.doFilter(request, response);
//        } else {
//            String authorizationHeader = request.getHeader(TokenConfiguration.TOKEN_HEADER);
//            if (authorizationHeader != null && authorizationHeader.startsWith(TokenConfiguration.TOKEN_HEADER_START_WITH)) {
//                try {
//                    String token = authorizationHeader.substring(TokenConfiguration.TOKEN_HEADER_START_WITH.length());
//                    Algorithm algorithm = Algorithm.HMAC256(tokenConfiguration.getSecretKey().getBytes());
//                    JWTVerifier verifier = JWT.require(algorithm).build();
//                    DecodedJWT decodedJWT = verifier.verify(token);
//                    String username = decodedJWT.getSubject();
//                    String businessType = decodedJWT.getClaim("business_type").asString();
//                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
//                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//                    stream(roles).forEach(r -> authorities.add(new SimpleGrantedAuthority(r)));
//                    // custom principle
//                    CustomPrinciple customPrinciple = jwtService.getPrinciple(token);
//                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customPrinciple, null, authorities);
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                    filterChain.doFilter(request, response);
//                } catch (Exception ex) {
//                    log.error(" Error logging in : {}", ex.getMessage());
//                    response.setHeader("error" , ex.getMessage());
//                    response.setStatus(FORBIDDEN.value());
//                    Map<String,String> error = new HashMap<>();
//                    error.put("error_msg", ex.getMessage());
//                    response.setContentType(APPLICATION_JSON_VALUE);
//                    new ObjectMapper().writeValue(response.getOutputStream(), error);
//                }
//            } else {
//                filterChain.doFilter(request, response);
//            }
//            // custom principle
////            CustomPrinciple customPrinciple = new CustomPrinciple();
////            customPrinciple.setUsername("888801");
////            customPrinciple.setBusinessType("250");
////            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customPrinciple, null, List.of(new SimpleGrantedAuthority("USER")));
////            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
////            filterChain.doFilter(request, response);
//        }
//    }
//}
//
