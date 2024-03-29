package com.ksmk.service;

import com.ksmk.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);

    List<User> findAll();

    User findByEmail(String email);

    void delete(Long id);
}
