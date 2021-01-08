package com.bulat.jobboard.repository;

import com.bulat.jobboard.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
    @RestResource(path = "byName", rel = "names")
    Optional<Company> findByName(String name);

    List<Company> findByUserId(Long user_id);
}
