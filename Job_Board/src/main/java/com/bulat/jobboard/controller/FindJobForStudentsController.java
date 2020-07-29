package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.*;
import com.bulat.jobboard.service.CityService;
import com.bulat.jobboard.service.CompanyService;
import com.bulat.jobboard.service.CountryService;
import com.bulat.jobboard.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/jobs")
public class FindJobForStudentsController {

    private final CountryService countryService;
    private final CityService cityService;
    private final SkillService skillService;
    private final CompanyService companyService;

    @Autowired
    public FindJobForStudentsController(CountryService countryService, CityService cityService, SkillService skillService, CompanyService companyService) {
        this.countryService = countryService;
        this.cityService = cityService;
        this.skillService = skillService;
        this.companyService = companyService;
    }

    @GetMapping
    public String getCompanies(Map<String, Object> model) {
        model.put("companies", companyService.findAll());
        model.put("jobNature", Arrays.asList(JobNature.values()));
        model.put("countries", countryService.findAll());
        model.put("cities", cityService.findAll());
        model.put("skills", skillService.findAll());
        model.put("experiences",Arrays.asList(Experience.values()));
        return "jobs";
    }

    @PostMapping
    public String sortForCompany(Company company) {
        System.out.println(company);
        return "jobs";
    }
}
