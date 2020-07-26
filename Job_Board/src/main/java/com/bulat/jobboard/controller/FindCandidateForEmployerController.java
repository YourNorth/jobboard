package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.Gender;
import com.bulat.jobboard.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Arrays;

@Controller
@RequestMapping("/candidates")
public class FindCandidateForEmployerController {

    private final CandidateService candidateService;

    @Autowired
    public FindCandidateForEmployerController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public String getCandidates(Map<String, Object> model){
        model.put("users", candidateService.findAll());
        model.put("genders",Arrays.asList(Gender.values()));
        return "candidate";
    }

    @PostMapping
    public String findCandidates(Candidate candidate, Gender gender){
        System.out.println(candidate);
        System.out.println(gender);
        return "candidate";
    }
}
