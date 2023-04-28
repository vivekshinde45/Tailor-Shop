package com.tailor.Shop.Mappings;

import org.springframework.stereotype.Component;

import com.tailor.Shop.Entities.Job;
import com.tailor.Shop.Payload.JobDto;

@Component
public class JobMapping {
    public Job dtoToJob(JobDto jobDto) {
        Job job = new Job();
        job.setImgname(jobDto.getImgname());
        job.setDescription(jobDto.getDescription());
        job.setActive(jobDto.isActive());
        return job;
    }

    public JobDto jobToDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setImgname(job.getImgname());
        jobDto.setDescription(job.getDescription());
        jobDto.setActive(job.isActive());
        return jobDto;
    }
}
