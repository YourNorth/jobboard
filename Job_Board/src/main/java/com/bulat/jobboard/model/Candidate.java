package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "candidates")
public class Candidate extends BaseEntity{

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "gender")
    private String gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="skill_id")
    private Skill skill;

    @Column(name = "education")
    private String education;

    @Column(name = "native_language")
    private String native_language;

    @Column(name = "link_img")
    private String link_img;
}
