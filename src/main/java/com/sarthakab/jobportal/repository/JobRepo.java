package com.sarthakab.jobportal.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sarthakab.jobportal.model.JobPost;

@Repository
public class JobRepo {
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

	public void addJob(JobPost jobPost) {
		jobs.add(jobPost);
		System.out.println(jobs);
	}
	
	public List<JobPost> getAllJobs() {
		return jobs;
	}
	
	
}