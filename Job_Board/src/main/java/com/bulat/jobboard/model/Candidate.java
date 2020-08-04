package com.bulat.jobboard.model;

import com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched
 * @see db.changelog/db.changelog-1.0.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "candidates")
public class Candidate extends BaseEntity implements GettersForCommonFieldsThatAreSearched {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "description", length = 3000)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_id")
    private City city;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="skill_id")
    private Skill skill;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="education_id")
    private Education education;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="language_id")
    private Language native_language;

    @Column(name = "link_img")
    private String link_img;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "candidate_company",
            joinColumns = {@JoinColumn(name = "candidate_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "feedback_for_candidate_id", referencedColumnName = "id")})
    private List<FeedbackForCandidate> feedbacks;
}
