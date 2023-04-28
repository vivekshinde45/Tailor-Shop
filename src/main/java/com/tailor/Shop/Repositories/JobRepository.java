package com.tailor.Shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailor.Shop.Entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
