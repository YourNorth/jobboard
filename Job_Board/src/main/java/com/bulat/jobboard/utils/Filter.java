package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.*;
import com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Filter {

    public List<? extends GettersForCommonFieldsThatAreSearched> findByCountryAndCityAndSkill(
            List<? extends GettersForCommonFieldsThatAreSearched> entities,
            Country country, City city, Skill skill) {
        if (!country.getName().equals("Country")){
            entities = entities.stream()
                    .filter(x -> x.getCountry().getName().equals(country.getName()))
                    .collect(Collectors.toList());
        }
        if (!city.getName().equals("City")){
            entities = entities.stream()
                    .filter(y -> y.getCity().getName().equals(city.getName()))
                    .collect(Collectors.toList());
        }
        if (!skill.getName().equals("Skill")){
            entities = entities.stream()
                    .filter(z -> z.getSkill().getName().equals(skill.getName()))
                    .collect(Collectors.toList());
        }
        return entities;
    }
}
