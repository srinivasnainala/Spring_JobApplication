package com.job.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.model.Company;
import com.job.repository.CompanyRepository;

@Service
public class CompanyService {
@Autowired
CompanyRepository companyrepository;

public List<Company> getCompanies() {
	return companyrepository.findAll();
}

public String addCompany(Company company) {
	return "Successfully added\n"+companyrepository.save(company);
}

public String updateCompany(int id, Company company) {
    try
    {
    	if(companyrepository.findById(id).get()!=null)
    	{
    		Company com=companyrepository.findById(id).get();
    		com.setName(company.getName());
    		com.setDescription(company.getDescription());
    		com.setJobs(company.getJobs());
    		companyrepository.save(com);
    		return "Successfully updated\n"+com;
    	}
    	else
    	{
    		throw new Exception("Not Found");
    	}
    }
	catch(Exception e)
    {
		return e.getMessage();
	}
}

public String deleteCompany(int id) {
	try
	{
		if(companyrepository.findById(id).isPresent())
		{
			companyrepository.deleteById(id);
			return "Deleted Successfully";
		}
		else
		{
			throw new Exception("No data found");
		}
	}
	catch(Exception e)
	{
	return e.getMessage();
	}
}

public String getCompanyById(int id) {
	try
	{
		if(companyrepository.findById(id).isPresent())
		{
			return ""+companyrepository.findById(id).get();
		}
		else
		{
			throw new Exception("Not found");
		}
	}
	catch(Exception e)
	{
		return e.getMessage();
	}

}

}
