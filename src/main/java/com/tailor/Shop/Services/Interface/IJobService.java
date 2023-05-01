package com.tailor.Shop.Services.Interface;

import java.util.List;

import com.tailor.Shop.Payload.JobDto;

public interface IJobService {
    // CRUD
    JobDto create(JobDto jobDto, Integer userId, String categoryName);

    JobDto update(JobDto jobDto, Integer jobId);

    void delete(Integer jobId);

    JobDto getById(Integer jobId);

    List<JobDto> getAll();

    List<JobDto> getAllByUser(Integer userId);

    List<JobDto> getAllByDescription(String description);

    List<JobDto> getJobsByLocation(String city);
}
