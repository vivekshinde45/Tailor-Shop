package com.tailor.Shop.Mappings;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tailor.Shop.Entities.Job;
import com.tailor.Shop.Entities.Quotation;
import com.tailor.Shop.Payload.JobDto;
import com.tailor.Shop.Payload.QuotationDto;

@Component
public class JobMapping {
    @Autowired
    private UserMapping _userMapping;

    @Autowired
    private QuotationMapping _quotationMapping;

    public Job dtoToJob(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setImgname(jobDto.getImgname());
        job.setDescription(jobDto.getDescription());
        job.setActive(jobDto.isActive());
        job.setBudget(jobDto.getBudget());
        job.setUser(this._userMapping.dtoToUser(jobDto.getUser()));
        // job.setCategory(this._categoryMapping.dtoTCategory(jobDto.getCategory()));
        if (jobDto.getQuotations() != null) {
            List<Quotation> quotations = jobDto.getQuotations().stream()
                    .map(quotationDto -> this._quotationMapping.dtoToQuotation(quotationDto))
                    .collect(Collectors.toList());
            job.setQuotations(quotations);
        }
        return job;
    }

    public JobDto jobToDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setImgname(job.getImgname());
        jobDto.setDescription(job.getDescription());
        jobDto.setActive(job.isActive());
        jobDto.setBudget(job.getBudget());
        jobDto.setUser(this._userMapping.userToDto(job.getUser()));
        // jobDto.setCategory(this._categoryMapping.categoryToDto(job.getCategory()));
        if (job.getQuotations() != null) {
            List<QuotationDto> quotations = job.getQuotations().stream()
                    .map(quotation -> this._quotationMapping.quotationToDto(quotation))
                    .collect(Collectors.toList());
            jobDto.setQuotations(quotations);
        }
        return jobDto;
    }
}
