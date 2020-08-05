package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The essence of feedback for a candidate company
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see db.changelog/db.changelog-1.4.xml
 */
@EqualsAndHashCode(callSuper = false)
@Entity(name = "feedbackForCandidates")
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackForCandidate extends BaseEntity{

    /** Unique company identifier */
    @Column(name = "company_id")
    private Long company_id;

    /** Name of the left application */
    @Column(name = "name")
    private String name;

    /** Contact information (mail) */
    @Column(name = "contact")
    private String contact;

    /** Link to candidate portfolio */
    @Column(name = "link_portfolio")
    private String link_portfolio;

    /** Application letter */
    @Column(name = "cover_letter", length = 5000)
    private String cover_letter;
}
