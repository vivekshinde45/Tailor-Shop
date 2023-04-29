package com.tailor.Shop.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailor.Shop.Entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findAllByUserId(Integer userId);
}
