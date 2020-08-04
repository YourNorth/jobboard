package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.service.*;
import com.bulat.jobboard.utils.Attributes;
import com.bulat.jobboard.utils.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/candidates")
public class FindCandidateForEmployerController {

    private final CandidateService candidateService;
    private final Attributes attributes;
    private final Filter filter;

    @Autowired
    public FindCandidateForEmployerController(CandidateService candidateService, Attributes attributes,
                                              Filter filter) {
        this.candidateService = candidateService;
        this.attributes = attributes;
        this.filter = filter;
    }

    @GetMapping
    public String getCandidates(Map<String, Object> model){
        model.put("candidates", candidateService.findAll());
        attributes.addAttributesForCandidates(model);
        return "candidate";
    }

    @GetMapping("/{skill}")
    public String getCandidateByKeySkills(@PathVariable(value="skill") String skill, Map<String, Object> model){
        List<Candidate> candidates = candidateService.findAll();
        model.put("candidates", filter.findBySkill(candidates, skill));
        attributes.addAttributesForCandidates(model);
        return "candidate";
    }

    @PostMapping
    public String findCandidates(Map<String, Object> model, Candidate candidate){
        List<Candidate> candidates = candidateService.findAll();
        attributes.addAttributesForCandidates(model);
        List<Candidate> preResult = (List<Candidate>) filter.findByCountryAndCityAndSkillAndGender(candidates, candidate);
        List<Candidate> result = filter.findByLanguageAndEducationAndFirstNameAndLastName(preResult, candidate);
        model.put("candidates", result);
        return "candidate";
    }
}
