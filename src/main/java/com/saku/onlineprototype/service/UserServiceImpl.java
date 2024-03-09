package com.saku.onlineprototype.service;

import com.saku.onlineprototype.dto.UserRequest;
import com.saku.onlineprototype.dto.UserResponse;
import com.saku.onlineprototype.entity.User;
import com.saku.onlineprototype.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new User {} to the database.",user.getUid());
        return userRepository.save(user);
    }

    @Override
    public UserResponse createUser(UserRequest request) throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        copyProperties(request, user);
        user =saveUser(user);
        return UserResponse.from(user);
    }

    @Override
    public UserResponse getUser(String uID) {
        User user = userRepository.findById(uID).orElseThrow();
        return UserResponse.from(user);
    }

    @Override
    public UserResponse updateUser(String uID, UserRequest request) {
        User user = userRepository.findById(uID).orElseThrow();
        user.setName(request.getName());
        user.setTelNo(request.getTelNo());
        user.setLastupdatetimestamp(LocalDateTime.now());
        user
        return null;
    }

    @Override
    public List<User> getAllUser() {
        log.info("Fetching all Catalogs");
        return userRepository.findAll();
    }

    @Override
    public boolean checkLoginAttempt(String ipAddress) {
        return true;
    }

}
