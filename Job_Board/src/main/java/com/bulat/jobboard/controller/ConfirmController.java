package com.bulat.jobboard.controller;

import com.bulat.jobboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for mail confirmation
 * @author Bulat Bilalov
 * @version 1.0
 */
@Controller
@RequestMapping("/token")
public class ConfirmController {

    private final UserService userService;

    @Autowired
    public ConfirmController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Method for checking a token for valid and user activation
     * @param token The confirmation character set that came to the user in the mail
     */
    @GetMapping("/{token}")
    public String checkToken(@PathVariable("token") String token){
        if (userService.confirm(token)) {
            return "redirect:/index";
        }
        return "/signIn";
    }
}
