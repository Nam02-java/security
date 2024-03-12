package com.example.Security.Security;

import com.example.Security.model.enitity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private int userId;
    private String userName;
    @JsonIgnore
    private String userPassword;
    private String email;
    private String phone;
    private boolean usersStatus;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public static CustomUserDetails mapUserToUserDetail(Users users) {
        List<GrantedAuthority> listAuthorities = users.getListRoles()
                .stream().map(roles -> new SimpleGrantedAuthority(roles.getRoleName().name()))
                .collect(Collectors.toList());


        //get roles form user entity
        // response customuserDetails
        return new CustomUserDetails(
                users.getUserId(),
                users.getUserName(),
                users.getPassword(),
                users.getEmail(),
                users.getPhone(),
                users.isUserStatus(),
                listAuthorities
        );
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
