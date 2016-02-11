package com.tothenew.intellimeet.service;

import com.tothenew.intellimeet.domain.User;
import com.tothenew.intellimeet.enums.Role;
import com.tothenew.intellimeet.repository.UserRepository;
import com.tothenew.intellimeet.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

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

    public Map<String, String> changePassword(String oldPassword, String newPassword) {
        Map<String, String> status = new HashMap<String, String>();
        User user = userRepository.findById(1L);
        if (user == null) {
            status.put("msg", "User Not Found");
        } else if (user.getPassword().equals(MD5.encode(oldPassword))) {
            user.setPassword(MD5.encode(newPassword));
            userRepository.save(user);
            status.put("msg", "Password successfull change");
        } else {
            status.put("msg", "You have entered wrong old password");
        }
        return status;
    }

    @Autowired
    UserRepository userRepository;
}
