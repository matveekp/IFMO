package com.example.fxserver.controllers;

import com.example.fxserver.entity.Task;
import com.example.fxserver.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
//    @RequestMapping(value = "/tasks", method = RequestMethod.GET) //getMapping аналогична этой аннотации request mapping
    Iterable<Task> allTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    Task taskById(@PathVariable Integer id){
        return taskRepository.findById(id).get();
    }

    @PostMapping("/tasks")
    Task addTask(@RequestBody Task task){
        return taskRepository.save(task);
    }
}
