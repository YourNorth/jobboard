package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.FeedbackForCompany;
import com.bulat.jobboard.service.CandidateService;
import com.bulat.jobboard.service.FeedbackForCompanyService;
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
public class CandidatesController {

    private final CandidateService candidateService;
    private final FeedbackForCompanyService feedbackForCompanyService;

    @Autowired
    public CandidatesController(CandidateService candidateService, FeedbackForCompanyService feedbackForCompanyService) {
        this.candidateService = candidateService;
        this.feedbackForCompanyService = feedbackForCompanyService;
    }

    @GetMapping("/candidate/{id}")
    public String getCandidate(@PathVariable("id") Long id, Map<String, Object> model, HttpServletRequest request){
        Optional<Candidate> candidateOptional = candidateService.findById(id);
        if (candidateOptional.isPresent()){
            model.put("candidates", Collections.singletonList(candidateOptional.get()));
            if (request.isUserInRole("ROLE_EMPLOYER"))
                return "candidate_details";
            else{
                return "candidate_details_less";
            }
        }else{
            return "candidate";
        }
    }

    @PostMapping("/candidate/{id}")
    public String addFeedback(@PathVariable("id") Long id, Map<String, Object> model,
                              HttpServletRequest request, FeedbackForCompany feedbackForCompany){
        Optional<Candidate> candidateOptional = candidateService.findById(id);
        if (candidateOptional.isPresent()){
            Candidate candidate = candidateOptional.get();
            model.put("candidates", Collections.singletonList(candidate));
            if (request.isUserInRole("ROLE_EMPLOYER")) {
                Attributes.addAttributesForEntity(feedbackForCompany);
                feedbackForCompany.setCandidate_id(candidate.getId());
                feedbackForCompanyService.save(feedbackForCompany);
                return "candidate_details";
            }else{
                return "candidate_details_less";
            }
        }else{
            return "candidate";
        }
    }
}
