package com.bulat.jobboard.service;

import com.bulat.jobboard.model.*;

import java.util.Date;

public interface GettersForCommonFieldsThatAreSearched {
    Country getCountry();
    void setCountry(Country country);
    City getCity();
    void setCity(City city);
    Skill getSkill();
    void setSkill(Skill skill);
    Gender getGender();
    void setGender(Gender gender);
    void setStatus(State status);
    void setCreated(Date date);
    void setUpdated(Date date);
}
