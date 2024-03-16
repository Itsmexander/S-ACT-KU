package com.saku.onlineprototype.service;

//import com.saku.onlineprototype.dto.UserDto;
import com.saku.onlineprototype.dto.UserRequest;
//import com.saku.onlineprototype.dto.UserRequestInfo;
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
import java.time.format.DateTimeFormatter;
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
        user.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
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
        user.setLastUpdateTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        user.setOrg(request.getOrg());
        user.setYear(request.getYear());
        user.setFaculty(request.getFaculty());
        return null;
    }

    @Override
    public List<User> getAllUser() {
        log.info("Fetching all User");
        return userRepository.findAll();
    }

//    @Override
//    public boolean checkLoginAttempt(String ipAddress) {
//        return true;
//    }
//
//    @Override
//    public void loginSuccess(UserRequestInfo userRequestInfo) {
//
//    }
//
//    @Override
//    public void loginFail(UserRequestInfo userRequestInfo) {
//
//    }
//
//    @Override
//    public UserDto getUserInfo(String username) {
//    return null;
//    }
//    @Override
//    public UserResponse changePassword(String oldPassword,String newPassword){
//
//    }

}
