package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.Company;
import com.bulat.jobboard.service.CandidateService;
import com.bulat.jobboard.service.CompanyService;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CreateProfileController {

    private final Attributes attributes;
    private final CandidateService candidateService;
    private final CompanyService companyService;

    @Autowired
    public CreateProfileController(Attributes attributes, CandidateService candidateService, CompanyService companyService) {
        this.attributes = attributes;
        this.candidateService = candidateService;
        this.companyService = companyService;
    }

    @GetMapping("/create_profile")
    public String getCreateProfile(HttpServletRequest request, Map<String, Object> model) {
        if (request.isUserInRole("ROLE_CANDIDATE")) {
            attributes.addAttributesForCandidates(model);
            return "profile_candidate";
        }
        if (request.isUserInRole("ROLE_EMPLOYER")) {
            attributes.addAttributesForCompanies(model);
            return "profile_work";
        }
        return "profile_candidate";
    }

    @PostMapping("/create_profile_candidate")
    public String createProfileForCandidate(Candidate candidate, @RequestParam("gender1") String gender) {
        System.out.println(candidate);
        candidateService.save(fillingTheCandidates(candidate, gender));
        return "redirect:/create_profile";
    }

    @PostMapping("/create_profile_employer")
    public String createProfileForEmployer(Company company, @RequestParam("gender1") String gender,
                                           @RequestParam("jobNature1") String jobNature,
                                           @RequestParam("experience1") String experience) {
        System.out.println(company);
        companyService.save(fillingTheCompanies(company, gender, jobNature, experience));
        return "redirect:/create_profile";
    }

    private Candidate fillingTheCandidates(Candidate candidate, String gender){
        attributes.addAttributesByIdsForCandidates(candidate, gender);
        candidate.setLink_img("/img/candiateds/" +(((int) ( Math.random() * 9)) + 1) + ".png");
        return candidate;
    }

    private Company fillingTheCompanies(Company company, String gender, String jobNature, String experience){
        attributes.addAttributesByIdsForCompanies(company, gender, jobNature, experience);
        company.setLink_img("/img/svg_icon/" + (((int) ( Math.random() * 4)) + 1) + ".svg");
        return company;
    }
}
