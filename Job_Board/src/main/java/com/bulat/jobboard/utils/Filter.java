package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.*;
import com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Filter {

    private final String DEFAULT_NAME_COUNTRY = "Country";
    private final String DEFAULT_NAME_CITY = "City";
    private final String DEFAULT_NAME_SKILL = "Skill";
    private final String DEFAULT_NAME_LANGUAGE = "Language";
    private final String DEFAULT_NAME_EDUCATION = "Education";

    private List<? extends GettersForCommonFieldsThatAreSearched> result;
    private List<Candidate> resultForCandidates = new ArrayList<>();
    private List<Company> resultForCompanies = new ArrayList<>();

    public List<? extends GettersForCommonFieldsThatAreSearched> findByCountryAndCityAndSkillAndGender(
            List<? extends GettersForCommonFieldsThatAreSearched> entities, GettersForCommonFieldsThatAreSearched entity) {
        String nameCountry = entity.getCountry().getName();
        String nameCity = entity.getCity().getName();
        String nameSkill = entity.getSkill().getName();
        result = entities;
        if (!nameCountry.equals(DEFAULT_NAME_COUNTRY)) {
            result = findByCountry(nameCountry);
        }
        if (!nameCity.equals(DEFAULT_NAME_CITY)) {
            result = findByCity(nameCity);
        }
        if (!nameSkill.equals(DEFAULT_NAME_SKILL)) {
            result = findBySkill(nameSkill);
        }
        if (!entity.getGender().equals(Gender.NotSpecified)) {
            result = findByGender(entity.getGender());
        }
        return result;
    }

    public List<Candidate> findByLanguageAndEducationAndFirstNameAndLastName(
            List<Candidate> candidates, Candidate candidate) {
        String nameLanguage = candidate.getNative_language().getName();
        String nameEducation = candidate.getEducation().getName();
        String firstName = candidate.getFirstName();
        String lastName = candidate.getLastName();
        resultForCandidates.addAll(candidates);
        candidates.clear();
        if (!nameLanguage.equals(DEFAULT_NAME_LANGUAGE)) {
            resultForCandidates = findByLanguage(nameLanguage);
        }
        if (!nameEducation.equals(DEFAULT_NAME_EDUCATION)) {
            resultForCandidates = findByEducation(nameEducation);
        }
        if (!firstName.isEmpty()) {
            resultForCandidates = findByFirstName(firstName);
        }
        if (!lastName.isEmpty()) {
            resultForCandidates = findByLastName(lastName);
        }
        return resultForCandidates;
    }

    public List<Company> findByExperienceAndJobNature(List<Company> companies, Company company){
        Experience experience = company.getExperience();
        JobNature jobNature = company.getJobNature();
        resultForCompanies.addAll(companies);
        companies.clear();
        if (!experience.equals(Experience.ANY)){
            resultForCompanies = findByExperience(experience);
        }
        if (!jobNature.equals(JobNature.ANY)){
            resultForCompanies = findByJobNature(jobNature);
        }
        return companies;
    }

    private List<? extends GettersForCommonFieldsThatAreSearched> findByCountry(String nameCountry) {
        return result.stream()
                .filter(x -> x.getCountry().getName().equals(nameCountry))
                .collect(Collectors.toList());
    }

    private List<? extends GettersForCommonFieldsThatAreSearched> findByCity(String nameCity) {
        return result.stream()
                .filter(x -> x.getCity().getName().equals(nameCity))
                .collect(Collectors.toList());
    }

    private List<? extends GettersForCommonFieldsThatAreSearched> findBySkill(String nameSkill) {
        return result.stream()
                .filter(x -> x.getSkill().getName().equals(nameSkill))
                .collect(Collectors.toList());
    }

    private List<? extends GettersForCommonFieldsThatAreSearched> findByGender(Gender gender) {
        return result.stream()
                .filter(x -> x.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    private List<Candidate> findByLanguage(String nameLanguage) {
        return resultForCandidates.stream()
                .filter(y -> y.getNative_language().getName().equals(nameLanguage))
                .collect(Collectors.toList());
    }

    private List<Candidate> findByEducation(String nameEducation) {
        return resultForCandidates.stream()
                .filter(y -> y.getEducation().getName().equals(nameEducation))
                .collect(Collectors.toList());
    }

    private List<Candidate> findByFirstName(String firstName) {
        return resultForCandidates.stream()
                .filter(y -> y.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    private List<Candidate> findByLastName(String lastName) {
        return resultForCandidates.stream()
                .filter(y -> y.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    private List<Company> findByExperience(Experience experience){
        return resultForCompanies.stream()
                .filter(y -> y.getExperience().equals(experience))
                .collect(Collectors.toList());
    }

    private List<Company> findByJobNature(JobNature jobNature){
        return resultForCompanies.stream()
                .filter(y -> y.getJobNature().equals(jobNature))
                .collect(Collectors.toList());
    }
}