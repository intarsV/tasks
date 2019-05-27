package com.accenture.tasks.controller;

import com.accenture.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TableController {

    private static final Map<Integer, String> STATUS = new HashMap<>();

    static {
        STATUS.put(0, "ACTIVE");
        STATUS.put(1, "INPROGRESS");
        STATUS.put(2, "CANCELLED");
        STATUS.put(3, "FINISHED");
    }

    private TaskService taskService;

    @Autowired
    public TableController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/table")
    public String table(Model model) {
        model.addAttribute("taskData", taskService.getAllTasks());
        model.addAttribute("statusOptions", STATUS);
        return "table";
    }

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "Yoloo! This is my first attempt of JSP");
        model.put("messageBoom", "This page is realy important");
        return "index";
    }

    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "Sorre, this is dummy page for testing!");
        return "next";
    }
}
