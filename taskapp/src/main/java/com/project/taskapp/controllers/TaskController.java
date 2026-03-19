package com.project.taskapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping("/say")
    public String sayhellow() {
        return "helllow";

    }
}
