package com.bulat.jobboard.service;

import com.bulat.jobboard.model.City;
import com.bulat.jobboard.model.Country;
import com.bulat.jobboard.model.Skill;

public interface GettersForCommonFieldsThatAreSearched {
    Country getCountry();
    City getCity();
    Skill getSkill();
}
