package com.rentmyboat.rentmyboat.service;

import com.rentmyboat.rentmyboat.configs.UserDetailsImpl;
import com.rentmyboat.rentmyboat.model.Users;
import com.rentmyboat.rentmyboat.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findByUsername(username);
        return user.map(UserDetailsImpl::new)
                .orElseThrow(()-> new UsernameNotFoundException("user {} not found" + username));
    }

}
