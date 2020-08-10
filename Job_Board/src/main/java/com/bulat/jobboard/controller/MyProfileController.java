package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.User;
import com.bulat.jobboard.security.details.UserDetailsImpl;
import com.bulat.jobboard.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MyProfileController {

    private final CandidateService candidateService;

    @Autowired
    public MyProfileController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/my_profile")
    public String myProfile(Authentication authentication, HttpServletRequest request, Map<String, Object> model){
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        if (request.isUserInRole("ROLE_CANDIDATE")) {
            List<Candidate> candidates = candidateService.findByUserId(user.getId());
            if (candidates.isEmpty()){
                return "not_have_profile";
            }else{
                model.put("candidates", candidates);
                return "candidate_details_less";
            }
        }
        if (request.isUserInRole("ROLE_EMPLOYER")) {

        }
        return "candidate_details_less";
    }
}
