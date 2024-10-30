package com.example.jobapplicationproject;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    List<Job> getAllJobs();
    void createJob(Job job);

    Job getJobbyID(Long id);

    void deleteJob(Long id);

    boolean updateJob(Long id, Job job);
}
