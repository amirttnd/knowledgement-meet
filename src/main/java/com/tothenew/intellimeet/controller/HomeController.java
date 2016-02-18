package com.tothenew.intellimeet.controller;

import com.tothenew.intellimeet.model.ResetPasswordModel;
import com.tothenew.intellimeet.repository.UserRepository;
import com.tothenew.intellimeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping({"/", "/home", "/index"})
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model, HttpServletRequest request, HttpSession httpSession, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        httpSession.setAttribute("currentUser", auth.getPrincipal());
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        Cookie cookie = new Cookie("_csrf", token.getToken());
        response.addCookie(cookie);
        model.addAttribute("username", auth.getName());
        return "admin";
    }

    @RequestMapping({"/login"})
    public ModelAndView login(HttpServletRequest request) {
        userService.findOrCreateDefaultUser();
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/home/changePassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> changePassword(@RequestBody ResetPasswordModel resetPasswordModel) {
        return new ResponseEntity<Map<String, String>>(userService.changePassword(resetPasswordModel.getOldPassword(), resetPasswordModel.getNewPassword()), HttpStatus.OK);
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("403");
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

