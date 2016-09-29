package io.github.bookcrawler.user;


import io.github.bookcrawler.entities.RobotUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;


public class RobotUserDetails implements UserDetails{

    RobotUser robotUser;

    public RobotUserDetails(RobotUser robotUser) {
        this.robotUser = robotUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return robotUser.getPassword();
    }

    @Override
    public String getUsername() {
        return robotUser.getLogin();
    }

    public String getName(){
        return robotUser.getName();
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
