package com.saku.onlineprototype.controller;

import com.saku.onlineprototype.dto.AuthCheckRequest;
import com.saku.onlineprototype.entity.User;
import com.saku.onlineprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth/check")
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
