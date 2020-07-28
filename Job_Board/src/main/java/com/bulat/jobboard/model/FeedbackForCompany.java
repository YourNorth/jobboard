package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Entity(name = "feedbackForCompanies")
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * @see This model is created in classpath:/db/changelog/db.changelog-1.5.xml
 */

public class FeedbackForCompany extends BaseEntity{

    @Column(name = "candidate_id")
    private Long candidate_id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "cover_letter")
    private String cover_letter;
}
