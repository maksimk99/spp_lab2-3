package com.bstu.spp.lab.spp_lab9.controller;

import com.bstu.spp.lab.spp_lab9.model.User;
import com.bstu.spp.lab.spp_lab9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(final Model model) {
        return "loginPage";
    }

    @GetMapping("/register")
    public String getRegisterPage(final Model model) {
        model.addAttribute("user", new User());
        return "registerPage";
    }

    @PostMapping("/register/submit")
    public String registerUser(@ModelAttribute @Valid final User user,
                               final BindingResult validationResults, final Model model) {
        if (validationResults.hasErrors()) {
            return "registerPage";
        }
        if (userService.getUserByUserName(user.getUserName()) != null) {
            model.addAttribute("registrationErrorMessage",
                    "can't register user, user with username = \"" + user.getUserName() + "\" already exist");
            return "registerPage";
        }
        userService.addUser(user);
        return "redirect:/login";
    }
}
