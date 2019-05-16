package com.accenture.tasks.services;

import com.accenture.tasks.domain.Task;
import com.accenture.tasks.domain.TaskStatusEnum;
import com.accenture.tasks.dto.TaskDTO;
import com.accenture.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
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

    public void deleteTask(TaskDTO taskDTO) {
        taskRepository.findById(taskDTO.getId())
                .ifPresent(taskRepository::delete);
    }

}
