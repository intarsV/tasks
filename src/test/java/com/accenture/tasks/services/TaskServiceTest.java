package com.accenture.tasks.services;

import com.accenture.tasks.domain.Task;
import com.accenture.tasks.domain.TaskStatusEnum;
import com.accenture.tasks.dto.ResponseDTO;
import com.accenture.tasks.dto.TaskDTO;
import com.accenture.tasks.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    private List<Task> list = new ArrayList<>();
    private TaskDTO taskDTO;
    private Task task;

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    private TaskService service;

    @Before
    public void init() {
        taskDTO = new TaskDTO(2L, "YYY", TaskStatusEnum.ACTIVE);
        task = new Task(2L, "YYY", TaskStatusEnum.ACTIVE);
        list.add(task);
    }

    @Test
    public void shouldReturnTaskList() {
        Mockito.when(taskRepository.findAll()).thenReturn(list);
        List<TaskDTO> result = service.getAllTasks();
        assertFalse(result.isEmpty());
        assertEquals("YYY", result.get(0).getTaskTitle());
        verify(taskRepository).findAll();
    }

    @Test
    public void shouldAddTask() {
        ArgumentCaptor<Task> taskArgumentCaptor = ArgumentCaptor.forClass(Task.class);
        when(taskRepository.save(taskArgumentCaptor.capture())).thenReturn(task);
        Long newId = service.saveTask(taskDTO);
        assertEquals(taskArgumentCaptor.getValue().getTaskTitle(), task.getTaskTitle());
        assertEquals(taskArgumentCaptor.getValue().getStatusEnum(), task.getStatusEnum());
        assertEquals(newId, Long.valueOf(2));
    }

    @Test
    public void shouldReturnOkMessageOnTaskDelete() {
        ResponseDTO response = new ResponseDTO("Deleted task with ID: " + taskDTO.getId() + "successfully failed!");
        when(taskRepository.findById(taskDTO.getId())).thenReturn(Optional.of(task));
        service.deleteTask(taskDTO);
        assertEquals(response.getMessage(), "Deleted task with ID: " + taskDTO.getId() + "successfully failed!");
        verify(taskRepository).delete(any(Task.class));
    }

    @Test
    public void shouldReturnErrorMessageOnTaskDelete() {
        ResponseDTO response = new ResponseDTO("Delete failed!");
        when(taskRepository.findById(taskDTO.getId())).thenReturn(Optional.empty());
        service.deleteTask(taskDTO);
        assertEquals(response.getMessage(), "Delete failed!");
    }

    @Test
    public void shouldUpdateTask() {
        when(taskRepository.findById(2L)).thenReturn(Optional.of(task));
        ResponseDTO response = service.updateTask(taskDTO);
        assertEquals(response.getMessage(), "Update successful!");
    }

    @Test
    public void shouldReturnErrorOnTaskUpdate() {
        when(taskRepository.findById(2L)).thenReturn(Optional.empty());
        ResponseDTO response = service.updateTask(taskDTO);
        assertEquals(response.getMessage(), "Oops, something went wrong!");
    }

}