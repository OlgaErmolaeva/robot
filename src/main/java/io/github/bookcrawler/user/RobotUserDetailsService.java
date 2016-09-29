package io.github.bookcrawler.user;


import io.github.bookcrawler.entities.RobotUser;
import io.github.bookcrawler.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RobotUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        List<RobotUser> robotUsers = userRepository.findByLogin(login);
        RobotUser robotUser = robotUsers.get(0);
        return new RobotUserDetails(robotUser);
    }
}
