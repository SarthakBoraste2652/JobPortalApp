<%@ page import="com.sarthakab.jobportal.model.JobPost" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Job Post</title>
    <!-- Include necessary CSS files -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-warning">
        <div class="container">
            <a class="navbar-brand fs-1 fw-medium" href="#">Job
                Portal Web App</a>
            <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="viewalljobs">About</a></li>
                    
                    <li class="nav-item"><a class="nav-link" href="https://sarthakboraste2652.github.io/Sarthaks-Portfolio/">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        <h2 class="mb-4 text-center font-weight-bold">Update Job Post</h2>

        <%-- Retrieve the postId from the request parameters --%>
        <c:set var="postId" value="${param.postId}" />

        <%-- Retrieve job post details based on the postId --%>
        <c:set var="jobPost" value="${jobPost}" />

        <!-- Your update form goes here -->
        <form action="/updateJob" method="post">
            <!-- Include necessary hidden fields for post ID or other data -->
            <input type="hidden" name="postId" value="${postId}">
            
            <div class="mb-3">
                <label for="postProfile" class="form-label">Post Profile</label>
                <input type="text" class="form-control" id="postProfile" name="postProfile" value="${jobPost.postProfile}" required>
            </div>

            <div class="mb-3">
                <label for="postDesc" class="form-label">Description</label>
                <textarea class="form-control" id="postDesc" name="postDesc" rows="4" required>${jobPost.postDesc}</textarea>
            </div>

            <div class="mb-3">
                <label for="reqExperience" class="form-label">Experience Required</label>
                <input type="number" class="form-control" id="reqExperience" name="reqExperience" value="${jobPost.reqExperience}" required>
            </div>

            <div class="mb-3">
                <label for="postTechStack" class="form-label">Tech Stack Required</label>
                <input type="text" class="form-control" id="postTechStack" name="postTechStack" value="${jobPost.postTechStack}" required>
            </div>

            <!-- Add other form fields as needed -->

            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>

    <!-- Include necessary JavaScript files -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</body>
</html>