package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Experience;
import com.bulat.jobboard.model.JobNature;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@Controller
public class CreateProfileController {

    private final Attributes attributes;

    @Autowired
    public CreateProfileController(Attributes attributes) {
        this.attributes = attributes;
    }

    @GetMapping("/create_profile")
    public String getCreateProfile(HttpServletRequest request, Map<String, Object> model){
        if (request.isUserInRole("ROLE_CANDIDATE")) {
            return "profile_candidate";
        }
        if (request.isUserInRole("ROLE_EMPLOYER")) {
            model.put("jobNature", Arrays.asList(JobNature.values()));
            model.put("experiences",Arrays.asList(Experience.values()));
            attributes.addAttributes(model);
            return "profile_work";
        }
        return "profile_candidate";
    }
}
