package com.accenture.tasks.domain;

public class Task {

    private Long id;
    private String taskTitle;
    private TaskStatusEnum statusEnum;

    public Task(Long id, String taskTitle, TaskStatusEnum statusEnum) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.statusEnum = statusEnum;
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
