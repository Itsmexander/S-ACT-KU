package com.saku.onlineprototype.controller;

import com.saku.onlineprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth/check")
    public boolean checkUID(@RequestBody String uid) {
        return userRepository.findById(uid).isPresent();
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
