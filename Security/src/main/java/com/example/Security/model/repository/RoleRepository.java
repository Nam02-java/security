package com.example.Security.model.repository;

import com.example.Security.model.enitity.ERole;
import com.example.Security.model.enitity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName(ERole roleName);

}
