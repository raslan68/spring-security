package com.ramiaslan.security.configuration.security;

import com.ramiaslan.security.entity.User;
import com.ramiaslan.security.exception.CustomException;
import com.ramiaslan.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
         if(optionalUser.isEmpty()) {
             throw new UsernameNotFoundException("User not found.");
         }

         return optionalUser.get();
    }
}
