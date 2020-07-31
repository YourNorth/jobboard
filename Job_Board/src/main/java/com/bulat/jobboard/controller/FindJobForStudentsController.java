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

@Controller
@RequestMapping("/jobs")
public class FindJobForStudentsController {

    private final CompanyService companyService;
    private final Attributes attributes;

    @Autowired
    public FindJobForStudentsController(CompanyService companyService, Attributes attributes) {
        this.companyService = companyService;
        this.attributes = attributes;
    }

    @GetMapping
    public String getCompanies(Map<String, Object> model) {
        model.put("companies", companyService.findAll());
        attributes.addAttributes(model);
        model.put("jobNature", Arrays.asList(JobNature.values()));
        model.put("experiences",Arrays.asList(Experience.values()));
        return "jobs";
    }

    @PostMapping
    public String sortForCompany(Map<String, Object> model, Company company) {
        model.put("companies", companyService.findAll());
        System.out.println(company);
        return "jobs";
    }
}
