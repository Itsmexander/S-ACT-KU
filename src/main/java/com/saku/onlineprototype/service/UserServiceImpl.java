package com.saku.onlineprototype.service;

//import com.saku.onlineprototype.dto.UserDto;
import com.saku.onlineprototype.dto.UserDao;
import com.saku.onlineprototype.dto.UserRequest;
//import com.saku.onlineprototype.dto.UserRequestInfo;
import com.saku.onlineprototype.dto.UserResponse;
import com.saku.onlineprototype.entity.User;
import com.saku.onlineprototype.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

@Service(value = "userService")
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private final UserDao userDao;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;


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
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        User user = userDao.findByUid(uid);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUid(),user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
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
