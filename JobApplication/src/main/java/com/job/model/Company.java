package com.job.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String description;
@JsonIgnore
@OneToMany(mappedBy="company")
private List<Job> jobs;
@JsonIgnore
@OneToMany(mappedBy="company")
private List<Review> review; 
public Company() {
	// TODO Auto-generated constructor stub
}
public Company(int id, String name, String description) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public List<Job> getJobs() {
	return jobs;
}
public void setJobs(List<Job> jobs) {
	this.jobs = jobs;
}

public List<Review> getReview() {
	return review;
}
public void setReview(List<Review> review) {
	this.review = review;
}
@Override
public String toString() {
	return "Company details :\nid=" + id + ",\nname=" + name + ",\ndescription=" + description + ",\njobs=" + jobs + "\nreview="+review;
}

}
