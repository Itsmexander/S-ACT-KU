package com.saku.onlineprototype.component;

import com.saku.onlineprototype.entity.User;
import com.saku.onlineprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ClientInitializer {

    @Autowired
    private UserRepository userRepository;
    public void run() {
    User user = new User("chawish.p","Chawish Pipopsophonchai","0614953963","USER", LocalDateTime.parse("2018-12-13T22:47:15.216"),"Admin");
    userRepository.save(user);

    Optional<User> optionalUser=userRepository.findById(user.getUID());
    User loadedUser = optionalUser.get();
        System.out.println(optionalUser.get());

        try {
        Thread.sleep(2000);
        } catch (InterruptedException e){
        e.printStackTrace();
        }

        loadedUser.setTelNo("0123456789");
        userRepository.save(loadedUser);
        System.out.println(userRepository.findById(loadedUser.getUID()).get());
    }
}
