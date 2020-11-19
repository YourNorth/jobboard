package com.bulat.jobboard.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Roles of various entities
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see org.springframework.security.core.GrantedAuthority
 * @see db.changelog/db.changelog-1.0.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "roles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity implements GrantedAuthority {

    /** Role name */
    @Column(name = "name")
    private String name;

    /** Users with this role */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    /** @return Returns the name of the role */
    @Override
    public String getAuthority() {
        return name;
    }
}
