package com.bulat.jobboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs")
public class FindJobForStudentsController {

    @GetMapping
    public String getJobs(){
        return "jobs";
    }
}
