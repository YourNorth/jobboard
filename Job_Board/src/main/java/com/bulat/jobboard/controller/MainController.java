package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.Company;
import com.bulat.jobboard.service.CandidateService;
import com.bulat.jobboard.service.CityService;
import com.bulat.jobboard.service.CompanyService;
import com.bulat.jobboard.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping({"/", "/index"})
public class MainController {

    private final CompanyService companyService;
    private final CityService cityService;
    private final SkillService skillService;
    private final CandidateService candidateService;

    @Autowired
    public MainController(CompanyService companyService, CityService cityService, SkillService skillService, CandidateService candidateService) {
        this.companyService = companyService;
        this.cityService = cityService;
        this.skillService = skillService;
        this.candidateService = candidateService;
    }

    @GetMapping
    public String getMain(Map<String, Object> model){
        List<Company> companies = IntStream.range(0, 5)
                .mapToObj(companyService.findAll()::get).collect(Collectors.toList());
        List<Candidate> candidates = IntStream.range(0, 12)
                .mapToObj(candidateService.findAll()::get).collect(Collectors.toList());
        model.put("companies", companies);
        model.put("candidates", candidates);
        model.put("cities", cityService.findAll());
        model.put("skills", skillService.findAll());
        return "index";
    }

    @PostMapping
    public String findJob(){
        return "redirect:/jobs";
    }
}
