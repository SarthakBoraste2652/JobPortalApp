package com.sarthakab.jobportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.sarthakab.jobportal.model.JobPost;
import com.sarthakab.jobportal.service.JobService;

import jakarta.websocket.server.PathParam;

@Controller
public class JobController {
	@Autowired
	private JobService service;
	
	@GetMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/addjob")
	public String addJob() {
		return "addjob";
	}
	
	@PostMapping("handleForm")
	public String jobAddSuccess(JobPost jobPost) {
		service.addJob(jobPost);
		return "success";
	}
	
	@GetMapping("viewalljobs")
	public String viewAllJobs(Model m) {
		List<JobPost> jobs = service.getAllJobs();
		m.addAttribute("jobPosts", jobs);
		return "viewalljobs";
	}
	
//	@GetMapping("/jobs/getPostDetails/{postId}")
//	public JobPost getJobPostDetails(@RequestParam("postId") int postId, Model m) {
//		System.out.println("Also i m in get method");
//		JobPost jobPost = service.getJobPostDetails(postId); 
//		m.addAttribute("jobPost", jobPost);
//		return jobPost;
//	}

	
	@GetMapping("/updateJobPost")
	public String showUpdateJobPage(@RequestParam("postId") Integer postId, Model model) {
	    // Retrieve job post details based on postId
		System.out.println("entered in showupdatepage");
	    JobPost jobPost = service.getJobPostDetails(postId);

	    // Add variables to the model
	    model.addAttribute("postId", postId);
	    model.addAttribute("jobPost", jobPost);
	    System.out.println("Jobpost is setted in model"+jobPost);
	    // Return the view name
	    return "updateJobPost";
	}

	
	// Handle the form submission for updating the job post
    @PostMapping("/updateJob")
    public String updateJobPost(@ModelAttribute JobPost jobPost) {
        // Implement your logic to update the job post in the database
        service.updateJobPost(jobPost);
        // Redirect to the main job post list page or another appropriate page
        return "redirect:/viewalljobs";
    }
    
    @DeleteMapping("/deleteJobPost/{postId}")
    public String deleteJobPost(@PathVariable int postId) {
        service.deleteJobPost(postId);
        return "redirect:/viewalljobs";
    }
    
	
	//testing url
	@GetMapping("/load")
	public void loadDB() {
		service.loadDB();
	}
}