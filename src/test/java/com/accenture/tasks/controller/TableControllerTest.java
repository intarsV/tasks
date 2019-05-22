package com.accenture.tasks.controller;

import com.accenture.tasks.domain.TaskStatusEnum;
import com.accenture.tasks.dto.TaskDTO;
import com.accenture.tasks.services.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TableController.class)
public class TableControllerTest {

    @MockBean
    private TaskService taskService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnIndexJsp() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", equalTo("Yoloo! This is my first attempt of JSP")))
                .andExpect(view().name("index"));
    }

    @Test
    public void shouldReturnTableJsp() throws Exception {
        TaskDTO taskDTO = new TaskDTO(1L, "very important Task", TaskStatusEnum.ACTIVE);
        List<TaskDTO> list = new ArrayList<>();
        list.add(taskDTO);
        when(taskService.getAllTasks()).thenReturn(Collections.singletonList(taskDTO));
        this.mockMvc.perform(get("/table")).andDo(print())
                .andExpect(model().attribute("taskData", equalTo(list)))
                .andExpect(view().name("table"));
    }

    @Test
    public void shouldReturnNextJsp() throws Exception {
        this.mockMvc.perform(get("/next")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", equalTo("Sorre, this is dummy page for testing!")))
                .andExpect(view().name("next"));
    }
}