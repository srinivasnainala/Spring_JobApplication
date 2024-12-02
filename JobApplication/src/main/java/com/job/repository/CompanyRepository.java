package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
