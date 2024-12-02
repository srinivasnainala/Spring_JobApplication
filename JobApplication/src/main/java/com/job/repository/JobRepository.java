package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.model.Job;

import jakarta.transaction.Transactional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
Job findByjobrole(String jobrole);
@Transactional
Job deleteByjobrole(String jobrole);
}
