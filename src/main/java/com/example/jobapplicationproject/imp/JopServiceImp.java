package com.example.jobapplicationproject.imp;

import com.example.jobapplicationproject.Job;
import com.example.jobapplicationproject.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class JopServiceImp implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextID = 1L;

    @Override
    public List<Job> getAllJobs() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextID++);
        jobs.add(job);

    }

    @Override
    public Job getJobbyID(Long id) {
    for (int i = 0; i < jobs.size(); i++){
        if (i == id){
            return jobs.get(i);
        }
    }
    return null;
    }

    @Override
    public void deleteJob(Long id) {
        for (int i = 0; i < jobs.size(); i++){
            if (i == id){
                jobs.remove(i);
            }
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for (Job job : jobs){
            if (job.getId().equals(id)){
                job.setLocation(updatedJob.getLocation());
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                return true;
            }
        }
        return false;
    }


}
