package com.tothenew.intellimeet.controller;

import com.tothenew.intellimeet.domain.User;
import com.tothenew.intellimeet.enums.Role;
import com.tothenew.intellimeet.repository.UserRepository;
import com.tothenew.intellimeet.service.UserService;
import com.tothenew.intellimeet.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping({"/", "/home", "/index"})
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping({"/admin"})
    public String admin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model, HttpServletRequest request) {
        String encodePassword = MD5.encode(password);
        User user = userRepository.findByUsernameAndPassword(username, encodePassword);
        long count = userRepository.count();
        if (user == null && count == 0) {
            user = userService.createUser(username, encodePassword, Role.ADMIN);
        } else if (user == null) {
            model.addAttribute("error", "Invalid Username or Password");
            return "redirect:/login";
        }
        model.addAttribute("username", user.getUsername());
        return "admin";
    }

    @RequestMapping({"/login"})
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/logout")
    public String logout(Model model) {
        model.addAttribute("logout", "Successful Logout");
        return "redirect:/login";
    }

    @RequestMapping({"/test"})
    public String test() {
        return "redirect:/login";
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
}

