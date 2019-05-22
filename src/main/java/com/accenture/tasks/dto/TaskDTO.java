package com.accenture.tasks.dto;

import com.accenture.tasks.domain.TaskStatusEnum;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;

public class TaskDTO {

    private Long id;

    @NotEmpty (message="Task should have some title!")
    @NonNull
    private String taskTitle;

    private TaskStatusEnum statusEnum;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String taskTitle, TaskStatusEnum statusEnumn) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.statusEnum = statusEnumn;
    }

    public TaskDTO(Long id) {
        this.id = id;
    }

    public TaskDTO(@NotEmpty String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public TaskStatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(TaskStatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
