package com.job.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Job {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int jobid;
private String jobrole;
private String job_description;
private int minsalary;
private int maxsalary;
private String location;
@ManyToOne
private Company company;

public Job() {
	// TODO Auto-generated constructor stub
}



public Job(int jobid, String jobrole, String job_description, int minsalary, int maxsalary, String location) {
	super();
	this.jobid = jobid;
	this.jobrole = jobrole;
	this.job_description = job_description;
	this.minsalary = minsalary;
	this.maxsalary = maxsalary;
	this.location = location;
}



public Company getCompany() {
	return company;
}



public void setCompany(Company company) {
	this.company = company;
}



public int getJobid() {
	return jobid;
}



public void setJobid(int jobid) {
	this.jobid = jobid;
}



public String getJobrole() {
	return jobrole;
}



public void setJobrole(String jobrole) {
	this.jobrole = jobrole;
}



public String getJob_description() {
	return job_description;
}



public void setJob_description(String job_description) {
	this.job_description = job_description;
}



public int getMinsalary() {
	return minsalary;
}



public void setMinsalary(int minsalary) {
	this.minsalary = minsalary;
}



public int getMaxsalary() {
	return maxsalary;
}



public void setMaxsalary(int maxsalary) {
	this.maxsalary = maxsalary;
}



public String getLocation() {
	return location;
}



public void setLocation(String location) {
	this.location = location;
}



@Override
public String toString() {
	return "Job Details :\njobid=" + jobid + ",\njob_role=" + jobrole + ",\njob_description=" + job_description + ",\nminsalary="
			+ minsalary + ",\nmaxsalary=" + maxsalary + ",\nlocation=" + location + "";
}

}
