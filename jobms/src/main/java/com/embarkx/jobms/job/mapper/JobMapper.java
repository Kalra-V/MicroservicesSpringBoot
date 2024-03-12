package com.embarkx.jobms.job.mapper;

import com.embarkx.jobms.job.Job;
import com.embarkx.jobms.job.dto.JobWithCompanyDTO;
import com.embarkx.jobms.job.external.Company;

public class JobMapper {
    public static JobWithCompanyDTO mapToJobWithCompanyDto(Job job,
                                                           Company company) {
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setCompany(company);

        return jobWithCompanyDTO;
    }
}
