package com.tothenew.intellimeet.service;

import com.tothenew.intellimeet.domain.User;
import com.tothenew.intellimeet.enums.Role;
import com.tothenew.intellimeet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserService {


    public User findOrCreateDefaultUser() {
        User user = null;
        long count = userRepository.countByRole(Role.ADMIN);
        if (count == 0) {
            user = createUser("knowledgemeet@tothenew.com", "igdefault", Role.ADMIN);
        }
        return user;
    }

    public User findByUsernameAndPassword(String username, String password) {
        password = passwordEncoder.encode(password);
        return userRepository.findByUsernameAndPassword(username, password);
    }


    public User createUser(String username, String password, Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        user.setEnabled(true);
        user.setEmail("tech-grails-intellimeet-team@tothenew.com ");
        return userRepository.save(user);

    }

    public Map<String, String> changePassword(String oldPassword, String newPassword) {
        Map<String, String> status = new HashMap<String, String>();
        User user = userRepository.findById(1L);
        if (user == null) {
            status.put("msg", "User Not Found");
        } else {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            status.put("msg", "Password successful changed");

        }
        return status;
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
}
