package com.job.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.model.Company;
import com.job.services.CompanyService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/companies")
public class CompanyController {
@Autowired
CompanyService companyservice;

@GetMapping("/")
public List<Company> getCompanies() 
{
    return companyservice.getCompanies() ;
}
@GetMapping("/{id}")
public String getCompanyById(@PathVariable int id) 
{
    return companyservice.getCompanyById(id) ;
}
@PostMapping("/addcompany")
public String addCompany(@RequestBody Company company)
{
	return companyservice.addCompany(company);
}
@PutMapping("/{id}")
public String updateCompany(@PathVariable int id,@RequestBody Company company)
{
	return companyservice.updateCompany(id,company);
}
@DeleteMapping("/delete/{id}")
public String deleteCompany(@PathVariable int id)
{
	return companyservice.deleteCompany(id);
}
}
