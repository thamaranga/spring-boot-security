package com.hasitha.springbootsecurity.service;

import com.hasitha.springbootsecurity.model.User;
import com.hasitha.springbootsecurity.model.UserDetailsImpl;
import com.hasitha.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<User> user= userRepository.findByUserName(userName);

       if(user.isPresent()) {
           return new UserDetailsImpl(user.get());
       }else {
        throw new UsernameNotFoundException(userName +" not found.");
       }
    }
}
