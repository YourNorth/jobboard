package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Company;
import com.bulat.jobboard.model.FeedbackForCandidate;
import com.bulat.jobboard.service.CompanyService;
import com.bulat.jobboard.service.FeedbackForCandidateService;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class CompaniesController {

    private final CompanyService companyService;
    private final FeedbackForCandidateService feedbackForCandidateService;

    @Autowired
    public CompaniesController(CompanyService companyService, FeedbackForCandidateService feedbackForCandidateService) {
        this.companyService = companyService;
        this.feedbackForCandidateService = feedbackForCandidateService;
    }

    @GetMapping("/company/{name}")
    public String getCompany(@PathVariable("name") String name, Map<String, Object> model, HttpServletRequest request) {
        Optional<Company> company = companyService.findByName(name);
        if (company.isPresent()) {
            model.put("companies", Collections.singletonList(company.get()));
            if (request.isUserInRole("ROLE_CANDIDATE"))
                return "job_details";
            else
                return "job_details_less";
        } else
            return "jobs";
    }

    @PostMapping("/company/{name}")
    public String addFeedback(@PathVariable("name") String name, Map<String,
            Object> model, HttpServletRequest request, FeedbackForCandidate feedback){
        Optional<Company> companyOptional = companyService.findByName(name);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            model.put("companies", Collections.singletonList(company));
            if (request.isUserInRole("ROLE_CANDIDATE")){
                Attributes.addAttributesForEntity(feedback);
                feedback.setCompany_id(company.getId());
                feedbackForCandidateService.save(feedback);
                return "job_details";
            }
        }
        return "jobs";
    }
}
