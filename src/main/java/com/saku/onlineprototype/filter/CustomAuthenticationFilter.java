package com.saku.onlineprototype.filter;

//import com.saku.onlineprototype.dto.UserRequestInfo;
import com.saku.onlineprototype.service.JwtService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;


@Slf4j
@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Autowired private JwtService jwtService;
    @Autowired private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            final String authorization = request.getHeader("Authorization");
            if (authorization != null && authorization.startsWith("Bearer ")) {
                final String token = authorization.substring(7);
                final Claims claims = jwtService.getClaims(token);
                if (claims.getExpiration().after(new Date())) {

                    final String username = claims.getSubject();
                    final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                    final UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails, null, userDetails.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

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
}

