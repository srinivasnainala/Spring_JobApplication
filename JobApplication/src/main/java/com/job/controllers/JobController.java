package com.job.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.model.Job;
import com.job.services.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	JobService jobservice;
	
	@PostMapping("/addjob")
	public String addjob(@RequestBody Job job)
	{
		return jobservice.addjob(job);
	}
	@GetMapping("/getAlljobs")
	public List<Job> getAlljobs()
	{
		return jobservice.getAllJobs();
	}
	@GetMapping("/getjob/{jobid}")
	public Job getJobById(@PathVariable int jobid)
	{
		return jobservice.getJobById(jobid);
	}
	@GetMapping("/getjobbyrole/{jobrole}")
	public Job getJobByRole(@PathVariable String jobrole)
	{
		return jobservice.getJobByRole(jobrole);
	}
	@PutMapping("/update/{jobrole}")
	public String update(@PathVariable String jobrole,@RequestBody Job job1)
	{
		return jobservice.updateJobByRole(jobrole,job1);
	}
	@DeleteMapping("/delete/{jobrole}")
	public ResponseEntity<String> delete(@PathVariable String jobrole)
	{
		return new ResponseEntity<>(jobservice.deleteByJobrole(jobrole),HttpStatus.NOT_FOUND);
	}
}
