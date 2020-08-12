package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.*;
import com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Class for identifying entities by various parameters
 * @author Bulat Bilalov
 * @version 1.0
 */
@Component
public class Filter {

    /** Default form value for countries */
    private final String DEFAULT_NAME_COUNTRY = "Country";

    /** Default form value for cities */
    private final String DEFAULT_NAME_CITY = "City";

    /** Default form value for skills */
    private final String DEFAULT_NAME_SKILL = "Skill";

    /** Default form value for languages */
    private final String DEFAULT_NAME_LANGUAGE = "Language";

    /** Default form value for educations */
    private final String DEFAULT_NAME_EDUCATION = "Education";

    /** Default form value for salary */
    private final String DEFAULT_VALUE_SALARY = "$750 - $24600/ Year";


    /** List of all entities to search */
    private List<? extends GettersForCommonFieldsThatAreSearched> result;

    /** List of all candidates for search */
    private List<Candidate> resultForCandidates = new ArrayList<>();

    /** List of all companies for search */
    private List<Company> resultForCompanies = new ArrayList<>();

    /**
     * A method that selects entities according to the following criteria: Country, City, Skill, Gender
     * @param entities Entity list to search
     * @param entity Entity by parameters that will be searched
     * @return List of entities satisfying search
     */
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

    /**
     * A method that selects entities according to the following criteria: Language, Education, FirstName, LastName
     * @param candidates Entity list to search
     * @param candidate Entity by parameters that will be searched
     * @return List of entities satisfying search
     */
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

    /**
     * A method that selects entities according to the following criteria: Experience, JobNature, Name, Age, Salary
     * @param companies Entity list to search
     * @param company Entity by parameters that will be searched
     * @return List of entities satisfying search
     */
    public List<Company> findByExperienceAndJobNatureAndNameAndAgeAndSalary(List<Company> companies, Company company) {
        Experience experience = company.getExperience();
        JobNature jobNature = company.getJobNature();
        String name = company.getName();
        String age = company.getAge();
        String salary = company.getSalary();
        resultForCompanies.addAll(companies);
        companies.clear();
        if (!experience.equals(Experience.ANY)) {
            resultForCompanies = findByExperience(experience);
        }
        if (!jobNature.equals(JobNature.ANY)) {
            resultForCompanies = findByJobNature(jobNature);
        }
        if (!name.isEmpty()) {
            resultForCompanies = findByName(name);
        }
        if (!age.isEmpty()) {
            resultForCompanies = findByAge(age);
        }
        if (!salary.equals(DEFAULT_VALUE_SALARY)) {
            resultForCompanies = findBySalary(salary);
        }
        return resultForCompanies;
    }


    /**
     * @param candidates Entity list to search
     * @param skill Search parameter
     * @return List of entities satisfying search
     */
    public List<Candidate> findBySkill(List<Candidate> candidates, String skill) {
        List<Candidate> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(".+" + skill + ".+");
        candidates.forEach(user -> {
            Matcher matcher = pattern.matcher(user.getSkill().getName());
            if (matcher.matches()) {
                result.add(user);
            }
        });
        return result;
    }

    /**
     * @param nameCountry Search parameter
     * @return List of entities satisfying search
     */
    private List<? extends GettersForCommonFieldsThatAreSearched> findByCountry(String nameCountry) {
        return result.stream()
                .filter(x -> x.getCountry().getName().equals(nameCountry))
                .collect(Collectors.toList());
    }

    /**
     * @param nameCity Search parameter
     * @return List of entities satisfying search
     */
    private List<? extends GettersForCommonFieldsThatAreSearched> findByCity(String nameCity) {
        return result.stream()
                .filter(x -> x.getCity().getName().equals(nameCity))
                .collect(Collectors.toList());
    }

    /**
     * @param nameSkill Search parameter
     * @return List of entities satisfying search
     */
    private List<? extends GettersForCommonFieldsThatAreSearched> findBySkill(String nameSkill) {
        return result.stream()
                .filter(x -> x.getSkill().getName().equals(nameSkill))
                .collect(Collectors.toList());
    }

    /**
     * @param gender Search parameter
     * @return List of entities satisfying search
     */
    private List<? extends GettersForCommonFieldsThatAreSearched> findByGender(Gender gender) {
        return result.stream()
                .filter(x -> x.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    /**
     * @param nameLanguage Search parameter
     * @return List of entities satisfying search
     */
    private List<Candidate> findByLanguage(String nameLanguage) {
        return resultForCandidates.stream()
                .filter(y -> y.getNative_language().getName().equals(nameLanguage))
                .collect(Collectors.toList());
    }

    /**
     * @param nameEducation Search parameter
     * @return List of entities satisfying search
     */
    private List<Candidate> findByEducation(String nameEducation) {
        return resultForCandidates.stream()
                .filter(y -> y.getEducation().getName().equals(nameEducation))
                .collect(Collectors.toList());
    }

    /**
     * @param firstName Search parameter
     * @return List of entities satisfying search
     */
    private List<Candidate> findByFirstName(String firstName) {
        return resultForCandidates.stream()
                .filter(y -> y.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    /**
     * @param lastName Search parameter
     * @return List of entities satisfying search
     */
    private List<Candidate> findByLastName(String lastName) {
        return resultForCandidates.stream()
                .filter(y -> y.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    /**
     * @param experience Search parameter
     * @return List of entities satisfying search
     */
    private List<Company> findByExperience(Experience experience) {
        return resultForCompanies.stream()
                .filter(y -> y.getExperience().equals(experience))
                .collect(Collectors.toList());
    }

    /**
     * @param jobNature Search parameter
     * @return List of entities satisfying search
     */
    private List<Company> findByJobNature(JobNature jobNature) {
        return resultForCompanies.stream()
                .filter(y -> y.getJobNature().equals(jobNature))
                .collect(Collectors.toList());
    }

    /**
     * @param name Search parameter
     * @return List of entities satisfying search
     */
    private List<Company> findByName(String name) {
        List<Company> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(name + ".+");
        resultForCompanies.forEach(user -> {
            Matcher matcher = pattern.matcher(user.getName());
            if (matcher.matches()) {
                result.add(user);
            }
        });
        return result;
    }

    /**
     * @param age Search parameter
     * @return List of entities satisfying search
     */
    private List<Company> findByAge(String age) {
        return resultForCompanies.stream()
                .filter(s -> Integer.parseInt(s.getAge().substring(0, 2)) <= Integer.parseInt(age))
                .filter(x -> Integer.parseInt(x.getAge().substring(3, 5)) >= Integer.parseInt(age))
                .collect(Collectors.toList());
    }

    /**
     * @param salary Search parameter
     * @return List of entities satisfying search
     */
    private List<Company> findBySalary(String salary) {
        Pattern pattern = Pattern.compile("[ $-/Year]");
        String[] words = pattern.split(salary);
        int min = Integer.parseInt(words[1]);
        int max = Integer.parseInt(words[5]);
        resultForCompanies = resultForCompanies.stream().filter(s ->
                Integer.parseInt(s.getSalary().substring(1)) > min)
                .collect(Collectors.toList());
        resultForCompanies = resultForCompanies.stream().filter(s ->
                Integer.parseInt(s.getSalary().substring(1)) < max)
                .collect(Collectors.toList());
        return resultForCompanies;
    }
}
