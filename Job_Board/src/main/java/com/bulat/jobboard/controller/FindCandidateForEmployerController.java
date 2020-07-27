package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.Gender;
import com.bulat.jobboard.service.*;
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
    private final CityService cityService;
    private final CountryService countryService;
    private final SkillService skillService;
    private final EducationService educationService;
    private final LanguageService languageService;

    @Autowired
    public FindCandidateForEmployerController(CandidateService candidateService, CityService cityService,
                                              CountryService countryService, SkillService skillService,
                                              EducationService educationService, LanguageService languageService) {
        this.candidateService = candidateService;
        this.cityService = cityService;
        this.countryService = countryService;
        this.skillService = skillService;
        this.educationService = educationService;
        this.languageService = languageService;
    }

    @GetMapping
    public String getCandidates(Map<String, Object> model){
        model.put("users", candidateService.findAll());
        model.put("genders", Arrays.asList(Gender.values()));
        model.put("cities", cityService.findAll());
        model.put("country", countryService.findAll());
        model.put("skills", skillService.findAll());
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
