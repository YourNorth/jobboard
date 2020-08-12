package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.*;
import com.bulat.jobboard.service.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Class for adding attributes for models and displaying positive and negative messages on the site
 * @author Bulat Bilalov
 * @version 1.0
 */
@Component
public class Attributes {

    private final CityService cityService;
    private final CountryService countryService;
    private final SkillService skillService;
    private final EducationService educationService;
    private final LanguageService languageService;

    /**
     * @param cityService Service interacting with the table of cities
     * @param countryService Service interacting with the table of countries
     * @param skillService Service interacting with the skill table (programming languages)
     * @param educationService Service interacting with the table of universities
     * @param languageService Service interacting with the language table
     */
    @Autowired
    public Attributes(CityService cityService, CountryService countryService, SkillService skillService,
                      EducationService educationService, LanguageService languageService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.skillService = skillService;
        this.educationService = educationService;
        this.languageService = languageService;
    }

    /**
     * Method for adding a window on success
     * @param map Page model with a successful window
     * @param message The message that will be displayed on the site
     */
    public static void addSuccessAttributes(@NotNull ModelMap map, String message) {
        map.addAttribute("title", "Good job!");
        map.addAttribute("message", message.isEmpty() ? "Success!" : message);
        map.addAttribute("category", "success");
    }

    /**
     * Method for adding a window on an unsuccessful process
     * @param map Error message page model
     * @param message The message that will be displayed on the site
     */
    public static void addErrorAttributes(@NotNull ModelMap map, String message) {
        map.addAttribute("title", "Oops!");
        map.addAttribute("message", message.isEmpty() ? "Error!" : message);
        map.addAttribute("category", "error");
    }


    /**
     * Method for adding a window where redirection occurs on successful process
     * @param redirectAttributes Redirect model for adding a message
     * @param message The message displayed in the window on the site
     */
    public static void addSuccessAttributesWithFlash(@NotNull RedirectAttributes redirectAttributes, String message){
        redirectAttributes.addFlashAttribute("title", "Good job!");
        redirectAttributes.addFlashAttribute("message", message.isEmpty() ? "Success!" : message);
        redirectAttributes.addFlashAttribute("category", "success");
    }

    /**
     * Method for adding a window where redirection occurs in case of an unsuccessful process
     * @param redirectAttributes Redirect model for adding a message
     * @param message The message displayed in the window on the site
     */
    public static void addErrorAttributesWithFlash(@NotNull RedirectAttributes redirectAttributes, String message){
        redirectAttributes.addFlashAttribute("title", "Oops!");
        redirectAttributes.addFlashAttribute("message", message.isEmpty() ? "Error!" : message);
        redirectAttributes.addFlashAttribute("category", "error");
    }

    /**
     * Method for adding basic fields for inherited classes BaseEntity
     * @param baseEntity Any class inheriting BaseEntity
     */
    public static void addAttributesForEntity(BaseEntity baseEntity) {
        baseEntity.setStatus(State.ACTIVE);
        baseEntity.setCreated(new Date());
        baseEntity.setUpdated(new Date());
    }

    /**
     * Method for adding basic objects to a model
     * @param model Model for adding basic elements
     */
    public void addAttributes(@NotNull Map<String, Object> model){
        model.put("countries", countryService.findAll());
        model.put("cities", cityService.findAll());
        model.put("skills", skillService.findAll());
        model.put("genders", Arrays.asList(Gender.values()));
    }

    /**
     * Method for adding master elements for candidate entity
     * @param model Model for adding basic elements
     */
    public void addAttributesForCandidates(@NotNull Map<String, Object> model){
        addAttributes(model);
        model.put("educations", educationService.findAll());
        model.put("languages", languageService.findAll());
    }

    /**
     * Method for adding basic elements for a company entity
     * @param model Model for adding basic elements
     */
    public void addAttributesForCompanies(Map<String, Object> model){
        addAttributes(model);
        model.put("jobNature", Arrays.asList(JobNature.values()));
        model.put("experiences",Arrays.asList(Experience.values()));
    }

    /**
     * Method for adding enumerated fields for a candidate entity
     * @param candidate Candidate object
     * @param gender Gender field
     */
    public void addAttributesByIdsForCandidates(Candidate candidate, String gender){
        addAttributesByIds(candidate);
        candidate.setGender(Gender.valueOf(gender));
        candidate.setEducation(educationService.findByName(candidate.getEducation().getName()).orElse(new Education()));
        candidate.setNative_language(languageService.findByName(candidate.getNative_language().getName()).orElse(new Language()));
    }

    /**
     * Method for adding enumerated fields for a company entity
     * @param company Company field
     * @param gender Gender field
     * @param jobNature JobNature field
     * @param experience Experience field
     */
    public void addAttributesByIdsForCompanies(Company company, String gender, String jobNature, String experience){
        addAttributesByIds(company);
        company.setGender(Gender.valueOf(gender));
        company.setJobNature(JobNature.valueOf(jobNature));
        company.setExperience(Experience.valueOf(experience));
    }

    /**
     * Method for adding enumerated fields for a entity
     * @param entity Entity in which to fit fields with enumeration
     */
    public void addAttributesByIds(GettersForCommonFieldsThatAreSearched entity){
        addAttributesForEntity((BaseEntity) entity);
        entity.setCountry(countryService.findByName(entity.getCountry().getName()).orElse(new Country()));
        entity.setCity(cityService.findByName(entity.getCity().getName()).orElse(new City()));
        entity.setSkill(skillService.findByName(entity.getSkill().getName()).orElse(new Skill()));
    }
}
