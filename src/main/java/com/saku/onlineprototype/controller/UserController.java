package com.saku.onlineprototype.controller;

import com.saku.onlineprototype.dto.UserRequest;
import com.saku.onlineprototype.dto.UserResponse;
import com.saku.onlineprototype.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) throws InvocationTargetException, IllegalAccessException {
        UserResponse response =userService.createUser(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/user/{uID}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String uID){
        UserResponse response = userService.getUser(uID);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/user/{uID}")
    public  ResponseEntity<UserResponse> updateUser(@PathVariable String uID, @RequestBody UserRequest request){
        UserResponse response = userService.updateUser(uID, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
