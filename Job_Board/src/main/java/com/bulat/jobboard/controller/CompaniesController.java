package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Company;
import com.bulat.jobboard.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Optional;

@Controller
public class CompaniesController {

    private final CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/company/{name}")
    public String getCompany(@PathVariable("name") String name, Map<String, Object> model){
        Optional<Company> company = companyService.findByName(name);
        if (company.isPresent()){
            model.put("companies", company.get());
            return "job_details";
        }
        return "jobs";
    }
}
