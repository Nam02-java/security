package com.example.Security.model.repository;

import com.example.Security.model.enitity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}

/**
 * @Repository
 * public interface UserRepository extends JpaRepository<Users,Integer> {
 *     public Users FindByUserName(String userName);
 *     boolean existsByUserName(String userName);
 *     boolean existsByEmail(String email);
 *
 * }
 */