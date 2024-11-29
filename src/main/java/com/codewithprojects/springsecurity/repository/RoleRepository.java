package com.codewithprojects.springsecurity.repository;

import com.codewithprojects.springsecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);  // Method to find a role by name
}
