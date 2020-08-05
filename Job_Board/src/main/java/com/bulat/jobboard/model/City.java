package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Storage class cities
 * @author Bulat Bilalov
 * @version 1.0
 * @see BaseEntity
 * @see db.changelog/db.changelog-1.2.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    /** City names*/
    @Column(name = "name")
    private String name;
}
