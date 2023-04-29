package com.tailor.Shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tailor.Shop.Payload.JobDto;
import com.tailor.Shop.Services.Implementation.JobService;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {
    @Autowired
    private JobService _jobService;

    @PostMapping("/user/{userId}/category/{categoryName}")
    public ResponseEntity<JobDto> create(@RequestBody JobDto jobDto,
            @PathVariable Integer userId,
            @PathVariable String categoryName) {
        JobDto savedJob = this._jobService.create(jobDto, userId, categoryName);
        return ResponseEntity.ok(savedJob);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<JobDto> update(@RequestBody JobDto jobDto,
            @PathVariable Integer jobId) {
        JobDto updatedJob = this._jobService.update(jobDto, jobId);
        return ResponseEntity.ok(updatedJob);
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> delete(@PathVariable Integer jobId) {
        this._jobService.delete(jobId);
        return ResponseEntity.ok("Job deleted successfully with ID: " + jobId);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobDto> getById(@PathVariable Integer jobId) {
        JobDto job = this._jobService.getById(jobId);
        return ResponseEntity.ok(job);
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getAll() {
        List<JobDto> jobs = this._jobService.getAll();
        return ResponseEntity.ok(jobs);
    }
}
