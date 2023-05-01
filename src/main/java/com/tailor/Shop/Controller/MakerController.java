package com.tailor.Shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tailor.Shop.Payload.JobDto;
import com.tailor.Shop.Services.Implementation.JobService;

@RestController
@RequestMapping("/api/v1/maker")
public class MakerController {
    @Autowired
    private JobService _jobService;

    /*
     * MAKER
     * 
     * 1. See All Jobs
     * 2. Filter Jobs by Name
     * 3. Filter Jobs by Location
     */
    @GetMapping
    public ResponseEntity<List<JobDto>> getAll() {
        List<JobDto> jobs = this._jobService.getAll();
        return ResponseEntity.ok(jobs);
    }

    // 2. Filter jobs by name
    @GetMapping("/{description}")
    public ResponseEntity<List<JobDto>> getJobsByName(@PathVariable String description) {
        List<JobDto> jobs = this._jobService.getAllByDescription(description);
        return ResponseEntity.ok(jobs);
    }

    // 3. Filter jobs by location
    @GetMapping("/city/{city}")
    public ResponseEntity<List<JobDto>> getJobsByLocation(@PathVariable String city) {
        List<JobDto> jobs = this._jobService.getJobsByLocation(city);
        return ResponseEntity.ok(jobs);
    }
}
