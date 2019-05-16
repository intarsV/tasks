package com.accenture.tasks.controller;


import com.accenture.tasks.dto.TaskDTO;
import com.accenture.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> findAll() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<TaskDTO> saveTask(@Valid @RequestBody TaskDTO taskDTO, UriComponentsBuilder builder) {
        Long id = taskService.saveTask(taskDTO);
        return new ResponseEntity(id, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<TaskDTO> deleteTask(@Valid @PathVariable("id") Long id) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(id);
        taskService.deleteTask(taskDTO);
        return new ResponseEntity<>(new TaskDTO(id), HttpStatus.OK);
    }
}
