package com.job.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.model.Job;
import com.job.repository.JobRepository;

import jakarta.transaction.Transactional;

@Service
public class JobService {
@Autowired
JobRepository jobrepository;

public String addjob(Job job) {
	return "New Job Added\n"+jobrepository.save(job);
}

public List<Job> getAllJobs() {
	return jobrepository.findAll();
}

public Job getJobById(int jobid) {
	return jobrepository.findById(jobid).get();
}

public Job getJobByRole(String jobrole) {
	return jobrepository.findByjobrole(jobrole);
}

public String updateJobByRole(String jobrole,Job job1) {
	try
	{
		if(jobrepository.findByjobrole(jobrole)!=null)
		{
	     Job job=jobrepository.findByjobrole(jobrole);
	     job.setJobrole(job1.getJobrole());
	     jobrepository.save(job);
	     return "Updated successfully\n"+job;
		}
		else
		{
			throw new Exception("No job exist with this role");
		}
	}
	catch(Exception e)
	{
		return e.getMessage();
	}
}
@Transactional
public String deleteByJobrole(String jobrole) {
	try
	{
		if(jobrepository.findByjobrole(jobrole)!=null)
		{
			return "Successfully deleted"+jobrepository.deleteByjobrole(jobrole);
		}
		else
		{
			throw new Exception("No data found with that role");
		}
	}
	catch(Exception e)
	{
	return e.getMessage();
	}
}

}
