package com.tailor.Shop.Mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tailor.Shop.Entities.Job;
import com.tailor.Shop.Payload.JobDto;

@Component
public class JobMapping {
    @Autowired
    private CategoryMapping _categoryMapping;

    @Autowired
    private QuotationMapping _quotationMapping;

    public Job dtoToJob(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setImgname(jobDto.getImgname());
        job.setDescription(jobDto.getDescription());
        job.setActive(jobDto.isActive());
        job.setCategory(this._categoryMapping.dtoTCategory(jobDto.getCategory()));
        job.setQuotation(this._quotationMapping.dtoToQuotation(jobDto.getQuotation()));
        return job;
    }

    public JobDto jobToDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setImgname(job.getImgname());
        jobDto.setDescription(job.getDescription());
        jobDto.setActive(job.isActive());
        jobDto.setCategory(this._categoryMapping.categoryToDto(job.getCategory()));
        jobDto.setQuotation(this._quotationMapping.quotationToDto(job.getQuotation()));
        return jobDto;
    }
}
