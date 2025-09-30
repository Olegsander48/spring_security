package com.udemy.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("/")
    public String getAllEmployees() {
        return "list";
    }

    @GetMapping("/hr_info")
    public String getHrInfo() {
        return "hr_info";
    }

    @GetMapping("/manager_info")
    public String getManagerInfo() {
        return "manager_info";
    }
}
