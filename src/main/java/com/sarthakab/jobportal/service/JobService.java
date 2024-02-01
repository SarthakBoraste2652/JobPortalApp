package com.sarthakab.jobportal.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthakab.jobportal.model.JobPost;
import com.sarthakab.jobportal.repository.JobRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo repo;
	
	public void addJob(JobPost jobPost) {
		repo.save(jobPost);
	}
	
	public List<JobPost> getAllJobs(){
		return repo.findAll();
	}

	public JobPost getJobPostDetails(int postId) {
		System.out.println("Enter in service get job details");
		JobPost job = repo.findById(postId).orElse(new JobPost());
		System.out.println("Retrieved object:"+job);
		return job;
	}

	public void loadDB() {
		List<JobPost> jobs = new ArrayList<>(Arrays.asList(
		new JobPost(1, "Frontend Developer", "Experience in building responsive web applications using React",
				3, List.of("HTML", "CSS", "JavaScript", "React")),
		new JobPost(2, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
				List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
		new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
				List.of("Python", "Machine Learning", "Data Analysis")),
		new JobPost(4, "Network Engineer",
				"Design and implement computer networks for efficient data communication", 5,
				List.of("Networking", "Cisco", "Routing", "Switching")),
		new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
				3, List.of("iOS Development", "Android Development", "Mobile App")
		
		)));
		
		repo.saveAll(jobs);
	}

	public void updateJobPost(JobPost jobPost) {
		repo.save(jobPost);		
	}
}
