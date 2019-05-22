package com.accenture.tasks.controller;

import com.accenture.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller

public class TableController {

    private TaskService taskService;

    @Autowired
    public TableController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/table")
    public String table(Model model) {
        model.addAttribute("taskData", taskService.getAllTasks());
        return "table";
    }

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "Yoloo! This is my first attempt of JSP");
        return "index";
    }

    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "Sorre, this is dummy page for testing!");
        return "next";
    }
}
