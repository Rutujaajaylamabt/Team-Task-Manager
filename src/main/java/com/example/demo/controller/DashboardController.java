package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private TaskRepository taskRepo;

    @GetMapping
    public Map<String, Object> getDashboard() {

        List<Task> tasks = taskRepo.findAll();

        long total = tasks.size();
        long completed = 0;

        for (Task t : tasks) {
            if ("DONE".equalsIgnoreCase(t.getStatus())) {
                completed++;
            }
        }

        Map<String, Object> data = new HashMap<>();
        data.put("totalTasks", total);
        data.put("completedTasks", completed);
        data.put("pendingTasks", total - completed);

        return data;
    }
}