package com.tailor.Shop.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailor.Shop.Payload.JobDto;
import com.tailor.Shop.Repositories.JobRepository;
import com.tailor.Shop.Services.Interface.IJobService;

@Service
public class JobService implements IJobService {
    @Autowired
    private JobRepository _jobRepository;

    @Override
    public JobDto create(JobDto jobDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crrate'");
    }

    @Override
    public JobDto update(JobDto jobDto, Integer jobId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer jobId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public JobDto getById(Integer jobId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<JobDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
