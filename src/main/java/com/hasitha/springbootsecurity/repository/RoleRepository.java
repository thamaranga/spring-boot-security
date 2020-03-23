package com.hasitha.springbootsecurity.repository;

import com.hasitha.springbootsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
