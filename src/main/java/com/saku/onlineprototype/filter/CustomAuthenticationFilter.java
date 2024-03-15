//package com.saku.onlineprototype.filter;
//
//import com.saku.onlineprototype.dto.*;
//
//import com.saku.onlineprototype.dto.UserRequestInfo;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.saku.onlineprototype.security.JwtService;
//import com.saku.onlineprototype.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//
//@Slf4j
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final AuthenticationManager authenticationManager;
//    private final UserService userService;
//    private final JwtService jwtService;
//
//    public CustomAuthenticationFilter(AuthenticationManager authenticationManagerBean, UserService userService, JwtService jwtService) {
//        this.authenticationManager = authenticationManagerBean;
//        this.userService = userService;
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        log.info("Username: {} ", username);
//        log.info("Password: {} ", password);
//        userService.checkLoginAttempt(getIpAddress(request));
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//        return authenticationManager.authenticate(authenticationToken);
//    }
//
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
//        CustomUser user = (CustomUser) authResult.getPrincipal();
//        UserDto userInfo = userService.getUserInfo(user.getUsername());
//        String issuer = request.getRequestURL().toString();
//        String accessToken = jwtService.getAccessToken(issuer,user.getUsername());
//        String refreshToken = jwtService.getRefreshToken(issuer,user.getUsername());
//        Map<String, Object> tokens = new HashMap<>();
//        tokens.put(TokenConfiguration.ACCESS_TOKEN, accessToken);
//        tokens.put("message" ,"Login Complete");
//        tokens.put(TokenConfiguration.REFRESH_TOKEN, refreshToken);
//        tokens.put(TokenConfiguration.USER_INFO, userInfo);
//        response.setContentType(APPLICATION_JSON_VALUE);
//        userService.loginSuccess(getUserRequestInfo(request));
//        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        userService.loginFail(getUserRequestInfo(request));
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.setContentType(APPLICATION_JSON_VALUE);
//        Map<String,String> errors = new HashMap<>();
//        errors.put("message", failed.getMessage());
//        new ObjectMapper().writeValue(response.getOutputStream(), errors);
//    }
//
//    private String getIpAddress(HttpServletRequest request) {
//        return request.getRemoteAddr();
//    }
//
//    private UserRequestInfo getUserRequestInfo(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String ipAddress = getIpAddress(request);
//        String browser = request.getHeader("user-agent");
//        return new UserRequestInfo()
//                .setIpAddress(ipAddress)
//                .setUsername(username)
//                .setBrowser(browser);
//
//    }
//}
//
