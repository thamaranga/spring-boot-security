package com.hasitha.springbootsecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private String userName="";
    private String passWord="";
    private boolean active=false;
    private List<GrantedAuthority> roles=new ArrayList<>();

    public UserDetailsImpl(User user){
        this.userName=user.getUserName();
        this.passWord=user.getPassWord();
        this.active=user.isActive();

        for(Role r : user.getRoles()){
            this.roles.add(new SimpleGrantedAuthority(r.getRoll()));

        }



    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return active;
    }
}
