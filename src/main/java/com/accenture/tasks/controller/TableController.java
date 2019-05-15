package com.accenture.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TableController {

    @RequestMapping("/table")
    public String table(Map<String, Object> model) {
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
