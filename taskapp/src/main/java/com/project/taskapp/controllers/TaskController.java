package com.project.taskapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/create")
    public String createtask() {
        return "task cereated";
    }

    @GetMapping("/delete")
    public String deletetask(){
        return "task deleted";
    }

    @GetMapping("/updateStatus")
    public String updatestatus(){
        return "status updated";
    }

    @GetMapping("/updateDescription")
    public String updatedescription(){
        return "description updated";
    }

    @GetMapping("/updateTitle")
    public String updatetitle(){
        return "Title updated";
    }

    @GetMapping("/updateAssignedTo")
    public String updateassignedto(){
        return "assigned to updated";
    }

    @GetMapping("/updateTask")
    public String updatetask(){
        return "task updated";
    }

    @GetMapping("/readTask")
    public String readtask(){
        return "task data";
    }

}
