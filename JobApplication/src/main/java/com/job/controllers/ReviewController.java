package com.job.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.model.Review;
import com.job.services.ReviewService;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
@Autowired
ReviewService reviewservice;
@GetMapping("/reviews")
public List<Review> getReviews(@PathVariable int companyId)
{
	return reviewservice.getReviews(companyId);
}
@PostMapping("/addreview")
public String addReview(@PathVariable int companyId,@RequestBody Review review)
{
	return reviewservice.addReview(companyId,review);
}
@PutMapping("/updatereview/{id}")
public String updateReview(@PathVariable int companyId,@PathVariable int id,@RequestBody Review review)
{
	return reviewservice.updateReview(companyId,id,review);
}
@DeleteMapping("/deletereview/{id}")
public String deleteReview(@PathVariable int companyId,@PathVariable int id)
{
	return reviewservice.deleteReview(companyId,id);
}
}
