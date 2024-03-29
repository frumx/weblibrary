package com.ksmk.service.impl;

import com.ksmk.dao.UserRepository;
import com.ksmk.model.User;
import com.ksmk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user=userRepository.findByEmail(email);

        if(user==null){
            throw new UsernameNotFoundException("User not found: " +email);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(user.getRole()==User.Role.ADMIN){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        else if(user.getRole()==User.Role.USER){
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }


        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
