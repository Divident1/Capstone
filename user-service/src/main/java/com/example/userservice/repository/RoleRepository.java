package com.example.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userservice.model.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
