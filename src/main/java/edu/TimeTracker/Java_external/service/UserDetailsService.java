package edu.TimeTracker.Java_external.service;

import edu.TimeTracker.Java_external.domain.entity.User;
import edu.TimeTracker.Java_external.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byUsername = userRepository.findByLogin(s);
        return byUsername;
    }
}
