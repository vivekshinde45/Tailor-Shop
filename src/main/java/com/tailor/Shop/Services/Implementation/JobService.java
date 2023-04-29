package com.tailor.Shop.Services.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailor.Shop.Entities.Category;
import com.tailor.Shop.Entities.Job;
import com.tailor.Shop.Entities.User;
import com.tailor.Shop.Exceptions.ResourceNotFoundException;
import com.tailor.Shop.Mappings.JobMapping;
import com.tailor.Shop.Mappings.QuotationMapping;
import com.tailor.Shop.Mappings.UserMapping;
import com.tailor.Shop.Payload.JobDto;
import com.tailor.Shop.Payload.QuotationDto;
import com.tailor.Shop.Repositories.CategoryRepository;
import com.tailor.Shop.Repositories.JobRepository;
import com.tailor.Shop.Repositories.UserRepository;
import com.tailor.Shop.Services.Interface.IJobService;

@Service
public class JobService implements IJobService {
    @Autowired
    private JobRepository _jobRepository;

    @Autowired
    private JobMapping _jobMapping;

    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private UserMapping _userMapping;

    @Autowired
    private CategoryRepository _categoryRepository;

    @Autowired
    private QuotationMapping _quotationMapping;

    @Override
    public JobDto create(JobDto jobDto, Integer userId, String categoryName) {
        User user = this._userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User",
                        "User Id",
                        userId + ""));
        Category category = this._categoryRepository.findByName(categoryName);
        if (category == null) {
            throw new ResourceNotFoundException("Category",
                    "Name",
                    categoryName);
        }
        jobDto.setUser(this._userMapping.userToDto(user));
        Job job = this._jobMapping.dtoToJob(jobDto);
        job.setCategory(category);
        job.setUser(user);
        job.setActive(true);
        Job savedJob = this._jobRepository.save(job);
        return this._jobMapping.jobToDto(savedJob);
    }

    @Override
    public JobDto update(JobDto jobDto, Integer jobId) {
        Job job = this._jobRepository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Job",
                        "Id",
                        jobId + ""));
        jobDto.setId(jobId);
        jobDto.setUser(this._userMapping.userToDto(job.getUser()));
        if (job.getQuotations() != null) {
            List<QuotationDto> quotations = job.getQuotations().stream().map(
                    quotation -> this._quotationMapping.quotationToDto(quotation)).collect(Collectors.toList());
            jobDto.setQuotations(quotations);
        }
        Job newJob = this._jobMapping.dtoToJob(jobDto);
        Job updatedJob = this._jobRepository.save(newJob);
        return this._jobMapping.jobToDto(updatedJob);
    }

    @Override
    public void delete(Integer jobId) {
        Job job = this._jobRepository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Job",
                        "Id",
                        jobId + ""));
        this._jobRepository.delete(job);
    }

    @Override
    public JobDto getById(Integer jobId) {
        Job job = this._jobRepository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Job",
                        "Id",
                        jobId + ""));
        return this._jobMapping.jobToDto(job);
    }

    @Override
    public List<JobDto> getAll() {
        List<JobDto> jobs = this._jobRepository.findAll().stream().map(
                job -> this._jobMapping.jobToDto(job)).collect(Collectors.toList());
        return jobs;
    }

}
