package com.sarthakab.jobportal.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthakab.jobportal.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

}