package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.*;
import com.bulat.jobboard.service.CompanyService;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.bulat.jobboard.utils.Filter;

@Controller
@RequestMapping("/jobs")
public class FindJobForStudentsController {

    private final CompanyService companyService;
    private final Attributes attributes;
    private final Filter filter;

    @Autowired
    public FindJobForStudentsController(CompanyService companyService, Attributes attributes, Filter filter) {
        this.companyService = companyService;
        this.attributes = attributes;
        this.filter = filter;
    }

    @GetMapping
    public String getCompanies(Map<String, Object> model) {
        model.put("companies", companyService.findAll());
        addAttributesForModel(model);
        return "jobs";
    }

    @PostMapping
    public String sortForCompany(Map<String, Object> model, Company company) {
        List<Company> companies = companyService.findAll();
        addAttributesForModel(model);
        List<Company> preResult = (List<Company>) filter.findByCountryAndCityAndSkillAndGender(companies, company);
        List<Company> result = filter.findByExperienceAndJobNature(preResult, company);
        model.put("companies", result);
        System.out.println(company);
        return "jobs";
    }

    private void addAttributesForModel(Map<String, Object> model){
        attributes.addAttributes(model);
        model.put("jobNature", Arrays.asList(JobNature.values()));
        model.put("experiences",Arrays.asList(Experience.values()));
    }
}
