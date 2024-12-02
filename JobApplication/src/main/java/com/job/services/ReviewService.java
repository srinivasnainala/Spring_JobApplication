package com.job.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.model.Company;
import com.job.model.Review;
import com.job.repository.CompanyRepository;
import com.job.repository.ReviewRepository;

@Service
public class ReviewService {
@Autowired
ReviewRepository reviewrepository;
@Autowired
CompanyRepository companyrepository;

public List<Review> getReviews(int companyId) {
	return reviewrepository.findByCompanyId(companyId);
}


public String addReview(int companyId, Review review) {
	try
	{
	Company company=companyrepository.findById(companyId).get();
     if(companyrepository.findById(companyId).isPresent())
     {
    	 review.setCompany(company);
    	 return "review Added Successfuuly\n "+ reviewrepository.save(review);
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


public String updateReview(int companyId, int id, Review review) {
   try
   {
	if(companyrepository.findById(companyId)!=null)
    {
    	Review re=reviewrepository.findById(id).get();
    	re.setDescription(review.getDescription());
    	reviewrepository.save(re);
    	return "Review Updated"+re;
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


public String deleteReview(int companyId, int id) {
    try
    {
    	if(companyrepository.findById(companyId).isPresent())
    	{
    		if(reviewrepository.findById(id).isPresent())
    		{
    			reviewrepository.deleteById(id);
    			return "Deleted Successfully ";
    		}
    		else
    		{
    			throw new Exception("Not found");
    		}
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
