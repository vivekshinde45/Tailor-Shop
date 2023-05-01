package com.tailor.Shop.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tailor.Shop.Entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findAllByUserId(Integer userId);

    List<Job> findAllByDescription(String description);

    @Query("FROM Job j JOIN j.user u JOIN u.address a WHERE a.city = :city")
    List<Job> findJobsByCity(@Param("city") String city);
}
