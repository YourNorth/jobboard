package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.Gender;
import com.bulat.jobboard.service.*;
import com.bulat.jobboard.utils.Attributes;
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
    private final Attributes attributes;
    private final EducationService educationService;
    private final LanguageService languageService;

    @Autowired
    public FindCandidateForEmployerController(CandidateService candidateService, Attributes attributes,
                                              EducationService educationService, LanguageService languageService) {
        this.candidateService = candidateService;
        this.attributes = attributes;
        this.educationService = educationService;
        this.languageService = languageService;
    }

    @GetMapping
    public String getCandidates(Map<String, Object> model){
        model.put("candidates", candidateService.findAll());
        attributes.addAttributes(model);
        model.put("genders", Arrays.asList(Gender.values()));
        model.put("educations", educationService.findAll());
        model.put("languages", languageService.findAll());
        return "candidate";
    }

    @PostMapping
    public String findCandidates(Candidate candidate, Gender gender){
        System.out.println(candidate);
        System.out.println(gender);
        return "candidate";
    }
}
