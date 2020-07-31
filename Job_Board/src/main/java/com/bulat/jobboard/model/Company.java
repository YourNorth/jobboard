package com.bulat.jobboard.model;

import com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "companies")

/**
 * @see This model is created in classpath:/db/changelog/db.changelog-1.4.xml
 */

public class Company extends BaseEntity implements GettersForCommonFieldsThatAreSearched {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "job_nature")
    @Enumerated(EnumType.STRING)
    private JobNature jobNature;

    @Column(name = "link_img")
    private String link_img;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="skill_id")
    private Skill skill;

    @Column(name = "salary")
    private String salary;

    @Column(name = "experience")
    @Enumerated(EnumType.STRING)
    private Experience experience;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "contact")
    private String contact;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "company_candidate",
            joinColumns = {@JoinColumn(name = "company_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "feedback_for_company_id", referencedColumnName = "id")})
    private List<FeedbackForCompany> feedbacks;
}
