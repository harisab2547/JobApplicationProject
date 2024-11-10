package com.example.jobapplicationproject.imp;

import com.example.jobapplicationproject.Job;
import com.example.jobapplicationproject.JobRepository;
import com.example.jobapplicationproject.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class JopServiceImp implements JobService {
    // private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;

    public JopServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
        // jobs.add(job);

    }

    @Override
    public Job getJobbyID(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJob(Long id) {

        jobRepository.deleteById(id);
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setLocation(updatedJob.getLocation());
          jobRepository.save(job);
            return true;
        }
        return false;
    }


}
