package com.saku.onlineprototype.service;

import com.saku.onlineprototype.entity.Role;
import com.saku.onlineprototype.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        // Find role by name using the roleDao
        Role role = roleRepository.findRoleByName(name);
        return role;
    }
}