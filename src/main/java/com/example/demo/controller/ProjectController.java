package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepo;

    // Create Project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepo.save(project);
    }

    // Get All Projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }
}