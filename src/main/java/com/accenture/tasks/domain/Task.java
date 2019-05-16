package com.accenture.tasks.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq", initialValue = 4, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "taskTitle")
    @NotBlank(message = "Name is really necessary")
    @NonNull
    private String taskTitle;

    @Column(name = "statusEnum")
    private TaskStatusEnum statusEnum;

    public Task() {
    }

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
