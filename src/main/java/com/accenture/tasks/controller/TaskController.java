package com.accenture.tasks.controller;

import com.accenture.tasks.dto.ResponseDTO;
import com.accenture.tasks.dto.TaskDTO;
import com.accenture.tasks.exception.TaskDeleteFailedException;
import com.accenture.tasks.exception.TaskUpdateFailedException;
import com.accenture.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> findAll() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<TaskDTO> saveTask(@RequestBody @Validated TaskDTO taskDTO) {
        Long id = taskService.saveTask(taskDTO);
        return new ResponseEntity(id, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<ResponseDTO> deleteTask(@PathVariable("id") Long id) {
        ResponseDTO response = taskService.deleteTask(id);
        if (response.getMessage().equals("Delete failed!")) {
            throw new TaskDeleteFailedException();
        }
        return new ResponseEntity(new TaskDTO(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateTask(@RequestBody TaskDTO taskDTO) {
        ResponseDTO response = taskService.updateTask(taskDTO);
        if (response.getMessage().equals("Oops, something went wrong!")) {
            throw new TaskUpdateFailedException();
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
