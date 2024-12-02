package com.job.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int rid;
private String description;
@JsonIgnore
@ManyToOne
private Company company;
public Review() {
	// TODO Auto-generated constructor stub
}
public Review(int rid, String description) {
	super();
	this.rid = rid;
	this.description = description;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}
@Override
public String toString() {
	return "Review:\nrid=" + rid + ",\ndescription=" + description + "";
}

}
