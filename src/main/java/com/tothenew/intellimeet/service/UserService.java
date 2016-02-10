package com.tothenew.intellimeet.service;

import com.tothenew.intellimeet.domain.User;
import com.tothenew.intellimeet.enums.Role;
import com.tothenew.intellimeet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    public User createUser(String username, String password, Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        System.out.println(userRepository);
        return userRepository.save(user);

    }

    @Autowired
    UserRepository userRepository;
}
