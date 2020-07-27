package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.*;

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

public class Company extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "jobNature")
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
}
