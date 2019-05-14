package com.accenture.tasks.dto;

import com.accenture.tasks.domain.TaskStatusEnum;

public class TaskDTO {

    private Long id;
    private String taskTitle;
    private TaskStatusEnum statusEnum;

    public TaskDTO(Long id, String taskTitle, TaskStatusEnum statusEnumn) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.statusEnum = statusEnumn;
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
