package com.bulat.jobboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subscribe")
public class SubscribersController {

    @PostMapping
    public String addSubscribe(){
        return "redirect:/index";
    }
}
