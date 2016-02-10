package com.tothenew.intellimeet.service;

import com.tothenew.intellimeet.domain.User;
import com.tothenew.intellimeet.repository.UserRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@Service
public class BootStrapService  {
    Logger log = Logger.getLogger(BootStrapService.class.getName());

    public void createUser(String username, String password) {
        log.info("Creating User");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(userRepository);
        userRepository.save(user);
    }

    @Autowired
    UserRepository userRepository;
}
