package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Subscribers who left mail on the site
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see db.changelog/db.changelog-1.5.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "subscribers")
public class Subscriber extends BaseEntity{

    /** Contact information subscription (mail) */
    @Column(name = "email")
    private String email;
}
