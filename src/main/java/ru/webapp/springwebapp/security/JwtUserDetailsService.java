package ru.webapp.springwebapp.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.webapp.springwebapp.model.User;
import ru.webapp.springwebapp.security.jwt.JwtUser;
import ru.webapp.springwebapp.security.jwt.JwtUserFactory;
import ru.webapp.springwebapp.service.UserService;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found!");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadByUsername - user with username: {} successfully loaded!", username);
        return jwtUser;
    }
}
