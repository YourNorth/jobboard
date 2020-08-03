package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.service.CandidateService;
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

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
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
}
