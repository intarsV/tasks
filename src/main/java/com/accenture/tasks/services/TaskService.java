package com.accenture.tasks.services;

import com.accenture.tasks.domain.Task;
import com.accenture.tasks.domain.TaskStatusEnum;
import com.accenture.tasks.dto.ResponseDTO;
import com.accenture.tasks.dto.TaskDTO;
import com.accenture.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks;
        tasks = taskRepository.findAll();

        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task t : tasks) {
            TaskDTO taskDTO = new TaskDTO(t.getId(), t.getTaskTitle(), t.getStatusEnum());
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    public Long saveTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTaskTitle(taskDTO.getTaskTitle());
        task.setStatusEnum(TaskStatusEnum.ACTIVE);
        return taskRepository.save(task).getId();
    }

    public ResponseDTO deleteTask(TaskDTO taskDTO) {
        ResponseDTO response = new ResponseDTO("Delete failed!");
        Optional<Task> searchTask = taskRepository.findById(taskDTO.getId());
        if (!searchTask.isPresent()) {
            return response;
        } else {
            taskRepository.delete(searchTask.get());
            response.setMessage("Deleted task with ID: " + taskDTO.getId() + "successfully");
        }
        return response;
    }

    public ResponseDTO updateTask(TaskDTO taskDTO) {
        ResponseDTO response = new ResponseDTO("Oops, something went wrong!");
        Task task;
        Optional<Task> searchForTask = taskRepository.findById(taskDTO.getId());
        if (!searchForTask.isPresent()) {
            return response;
        }
        task = searchForTask.get();
        task.setStatusEnum(taskDTO.getStatusEnum());
        taskRepository.save(task);
        response.setMessage("Update successful!");
        return response;
    }
}
