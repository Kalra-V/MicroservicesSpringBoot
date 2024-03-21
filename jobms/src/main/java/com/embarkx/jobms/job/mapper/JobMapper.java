package com.embarkx.jobms.job.mapper;

import com.embarkx.jobms.job.Job;
import com.embarkx.jobms.job.dto.JobDTO;
import com.embarkx.jobms.job.external.Company;
import com.embarkx.jobms.job.external.Reviews;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDto(Job job,
                                                Company company,
                                                List<Reviews> reviews) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setCompany(company);
        jobDTO.setReview(reviews);

        return jobDTO;
    }
}
