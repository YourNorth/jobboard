package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Company;
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

    @Autowired
    public MainController(CompanyService companyService, CityService cityService, SkillService skillService) {
        this.companyService = companyService;
        this.cityService = cityService;
        this.skillService = skillService;
    }

    @GetMapping
    public String getMain(Map<String, Object> model){
        List<Company> companies = IntStream.range(0, 5)
                .mapToObj(companyService.findAll()::get).collect(Collectors.toList());
        model.put("companies", companies);
        model.put("cities", cityService.findAll());
        model.put("skills", skillService.findAll());
        return "index";
    }

    @PostMapping
    public String findJob(){
        return "redirect:/jobs";
    }
}
