package com.bulat.jobboard.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Base entity for common fields
 * @author Bulat Bilalov
 * @version 1.0
 */
@MappedSuperclass
@Data
public class BaseEntity {

    /** Primary key for an entity */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Entity creation date */
    @CreatedDate
    @Column(name = "created")
    private Date created;

    /** Date of entity update */
    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    /** Entity status */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private State status;
}
