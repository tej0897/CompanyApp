package com.example.CompanyApp.Repos;

import com.example.CompanyApp.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CompanyRepo extends JpaRepository<Company, Integer> {
}
