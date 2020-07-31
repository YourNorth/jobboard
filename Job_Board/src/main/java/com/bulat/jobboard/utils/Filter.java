package com.bulat.jobboard.utils;

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
}
