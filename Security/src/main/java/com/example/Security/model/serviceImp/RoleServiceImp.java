package com.example.Security.model.serviceImp;

import com.example.Security.model.enitity.ERole;
import com.example.Security.model.enitity.Roles;
import com.example.Security.model.repository.RoleRepository;
import com.example.Security.model.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Roles> findByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
