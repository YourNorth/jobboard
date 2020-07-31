package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.Gender;
import com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Filter {

    private final String DEFAULT_NAME_COUNTRY = "Country";
    private final String DEFAULT_NAME_CITY = "City";
    private final String DEFAULT_NAME_SKILL = "Skill";
    private final String DEFAULT_NAME_LANGUAGE = "Language";
    private final String DEFAULT_NAME_EDUCATION = "Education";

    public List<? extends GettersForCommonFieldsThatAreSearched> findByCountryAndCityAndSkillAndGender(
            List<? extends GettersForCommonFieldsThatAreSearched> entities, GettersForCommonFieldsThatAreSearched entity) {
        String nameCountry = entity.getCountry().getName();
        String nameCity = entity.getCity().getName();
        String nameSkill = entity.getSkill().getName();
        if (!nameCountry.equals(DEFAULT_NAME_COUNTRY)) {
            entities = findByCountry(entities, nameCountry);
        }
        if (!nameCity.equals(DEFAULT_NAME_CITY)) {
            entities = findByCity(entities, nameCity);
        }
        if (!nameSkill.equals(DEFAULT_NAME_SKILL)) {
            entities = findBySkill(entities, nameSkill);
        }
        entities = findByGender(entities, entity.getGender());
        return entities;
    }

    public List<Candidate> findByLanguageAndEducation(List<Candidate> candidates, Candidate candidate){
        String nameLanguage = candidate.getNative_language().getName();
        String nameEducation = candidate.getEducation().getName();
        if (!nameLanguage.equals(DEFAULT_NAME_LANGUAGE)){
            candidates = findByLanguage(candidates, nameLanguage);
        }
        if (!nameEducation.equals(DEFAULT_NAME_EDUCATION)){
            candidates = findByEducation(candidates, nameEducation);
        }
        return candidates;
    }

    private List<? extends GettersForCommonFieldsThatAreSearched> findByCountry(
            List<? extends GettersForCommonFieldsThatAreSearched> entities, String nameCountry){
        return entities.stream()
                .filter(x -> x.getCountry().getName().equals(nameCountry))
                .collect(Collectors.toList());
    }

    private List<? extends GettersForCommonFieldsThatAreSearched> findByCity(
            List<? extends GettersForCommonFieldsThatAreSearched> entities, String nameCity){
        return entities.stream()
                .filter(x -> x.getCity().getName().equals(nameCity))
                .collect(Collectors.toList());
    }

    private List<? extends GettersForCommonFieldsThatAreSearched> findBySkill(
            List<? extends GettersForCommonFieldsThatAreSearched> entities, String nameSkill){
        return entities.stream()
                .filter(x -> x.getSkill().getName().equals(nameSkill))
                .collect(Collectors.toList());
    }

    private List<? extends GettersForCommonFieldsThatAreSearched> findByGender(
            List<? extends GettersForCommonFieldsThatAreSearched> entities, Gender gender){
        return entities.stream()
                .filter(x -> x.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    private List<Candidate> findByLanguage(List<Candidate> candidates, String nameLanguage){
        return candidates.stream()
                .filter(y -> y.getNative_language().getName().equals(nameLanguage))
                .collect(Collectors.toList());
    }

    private List<Candidate> findByEducation(List<Candidate> candidates, String nameEducation){
        return candidates.stream()
                .filter(y -> y.getEducation().getName().equals(nameEducation))
                .collect(Collectors.toList());
    }
}
