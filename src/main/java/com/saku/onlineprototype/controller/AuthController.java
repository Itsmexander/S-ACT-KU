package com.saku.onlineprototype.controller;

import com.saku.onlineprototype.dto.AuthCheckRequest;
import com.saku.onlineprototype.dto.AuthRequestDTO;
import com.saku.onlineprototype.dto.AuthResponseDTO;
import com.saku.onlineprototype.dto.UserRequest;
import com.saku.onlineprototype.entity.User;
import com.saku.onlineprototype.repository.UserRepository;
import com.saku.onlineprototype.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserRepository userRepository;
    @Autowired private AuthService authService;

    @PostMapping("/check")
    public boolean checkUID(@RequestBody AuthCheckRequest authCheckRequest) {
        System.out.println(authCheckRequest.getUid());
        if (userRepository.findByUid(authCheckRequest.getUid()).isPresent()){
            System.out.println("true");
            return userRepository.findByUid(authCheckRequest.getUid()).isPresent();
        }else {
            System.out.println("false");
            return userRepository.findByUid(authCheckRequest.getUid()).isPresent();
        }
//        return userRepository.findByUid(uid).isPresent();
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody UserRequest dto) throws InvocationTargetException, IllegalAccessException {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO dto) {
        return ResponseEntity.ok(authService.authenticate(dto));
    }

    @GetMapping("/getAllUser")
    public Optional<User> getAllUser(){
        return userRepository.findByUid("b6210451098");
    }
//    @GetMapping("/login")
//    public String loginView() {
//        return "login"; // return login.html
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request,
//                         HttpServletResponse response,
//                         Authentication auth) {
//
//        if (auth != null){
//            new SecurityContextLogoutHandler()
//                    .logout(request, response, auth);
//        }
//        // You can redirect wherever you want, but generally it's a good
//        // practice to show the login screen again.
//        return "redirect:/login?logout";
//    }
}
