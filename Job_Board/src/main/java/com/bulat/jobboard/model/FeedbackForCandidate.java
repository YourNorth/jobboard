package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Entity(name = "feedbackForCandidates")
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * @see This model is created in classpath:/db/changelog/db.changelog-1.4.xml
 */

public class FeedbackForCandidate extends BaseEntity{

    @Column(name = "company_id")
    private Long company_id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "link_portfolio")
    private String link_portfolio;

    @Column(name = "cover_letter", length = 5000)
    private String cover_letter;
}
