package com.saku.onlineprototype.service;


import com.saku.onlineprototype.dto.UserRequest;
import com.saku.onlineprototype.dto.UserResponse;
import com.saku.onlineprototype.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserService {
    User saveUser (User user);
    UserResponse createUser(UserRequest request) throws InvocationTargetException, IllegalAccessException;
    UserResponse getUser(String uID);
    UserResponse updateUser(String uID, UserRequest request);
    List<User> getAllUser();
}
