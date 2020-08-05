package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The essence of different languages
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see db.changelog/db.changelog-1.2.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    /** Language name */
    @Column(name = "name")
    private String name;
}
