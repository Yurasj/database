package com.rozhan.repository;

import com.rozhan.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Procedure("dynamic_procedure")
    void dynamic_procedure();
}
