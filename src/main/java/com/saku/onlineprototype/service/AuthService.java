package com.saku.onlineprototype.service;

import com.saku.onlineprototype.dto.*;
import com.saku.onlineprototype.entity.User;
import com.saku.onlineprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;
    @Autowired private JwtService jwtService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AuthenticationManager authenticationManager;
    public AuthResponseDTO register(UserRequest userRequest) throws InvocationTargetException, IllegalAccessException {
        UserResponse user = userService.createUser(userRequest);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(jwtService.generateToken(user.getUid()));
        return authResponseDTO;
    }

    public AuthResponseDTO authenticate(AuthRequestDTO dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUid(),
                        dto.getPassword()));

        final Optional<User> user = userRepository.findByUid(dto.getUid());
        System.out.println(user);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(jwtService.generateToken(user.get().getUid()));
        return authResponseDTO;
    }

}
