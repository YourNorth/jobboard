package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class responsible for the blog theme
 * @author Bulat Bilalov
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "topics")
public class Topic extends BaseEntity{

    /** Blog topic name */
    @Column(name = "name")
    private String name;
}
