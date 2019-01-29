package com.example.oauth2demo.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return mockUser(s);
    }

    private UserDetails mockUser(String username) {
        String userName = "test@test.com";
        String userPass = "tester";

        if (!userName.equals(userName)) {
            throw new UsernameNotFoundException("invalid username or password");
        }

        UserDetails user = User.withDefaultPasswordEncoder()
                .username(username)
                .password(userPass)
                .authorities(getAuthority())
                .build();

        return user;
    };

    private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.emptyList();
    }
}
