package com.saku.onlineprototype.service;


import com.saku.onlineprototype.entity.Role;

// Declaring the RoleService interface
public interface RoleService {
    // Method to find a Role by its name
    Role findByName(String name);
}

