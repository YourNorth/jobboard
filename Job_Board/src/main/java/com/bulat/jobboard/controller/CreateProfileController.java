package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CreateProfileController {

    private final Attributes attributes;

    @Autowired
    public CreateProfileController(Attributes attributes) {
        this.attributes = attributes;
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
    public String createProfileForCandidate(Candidate candidate) {
        System.out.println(candidate);
        return "redirect:/create_profile";
    }
}
