package com.accenture.tasks.controller;


import com.accenture.tasks.domain.TaskStatusEnum;
import com.accenture.tasks.dto.TaskDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MockedTaskController {

    @GetMapping("/mock/tasks")
    public List<TaskDTO> getMockedTask() {
        List<TaskDTO> taskList = new ArrayList<>();
        taskList.add(new TaskDTO(1L, "do homework", TaskStatusEnum.ACTIVE));
        taskList.add(new TaskDTO(2L, "do eat", TaskStatusEnum.ACTIVE));
        taskList.add(new TaskDTO(3L, "do sleep", TaskStatusEnum.ACTIVE));
        return taskList;
    }
}
