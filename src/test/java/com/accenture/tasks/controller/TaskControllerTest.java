package com.accenture.tasks.controller;

import com.accenture.tasks.domain.TaskStatusEnum;
import com.accenture.tasks.dto.TaskDTO;
import com.accenture.tasks.services.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTest {

    private TaskDTO taskDTO;

    @MockBean
    private TaskService taskService;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void init() {
        taskDTO = new TaskDTO(1L, "new special task", TaskStatusEnum.ACTIVE);
    }

    @Test
    public void shouldReturnTaskDTOList() throws Exception {
        List<TaskDTO> response = new ArrayList();
        response.add(taskDTO);
        when(this.taskService.getAllTasks()).thenReturn(response);
        mockMvc.perform(get("/api/v1/tasks")).andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"taskTitle\":\"new special task\",\"statusEnum\":\"ACTIVE\"}]"));
    }

    @Test
    public void shouldAddTaskDTO() throws Exception {
        when(this.taskService.saveTask(any(TaskDTO.class))).thenReturn(100L);
        String body = "{\"taskTitle\":\"megatask\"}";
        mockMvc.perform(post("/api/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(body))
                .andExpect(status().isCreated())
                .andExpect(content().json("100"));
    }

    @Test
    public void shouldDeleteTaskDTO() throws Exception {
        final long taskId = 7L;
        mockMvc.perform(delete("/api/v1/tasks/" + taskId))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":" + taskId + ",\"taskTitle\":null,\"statusEnum\":null}"));
    }
}