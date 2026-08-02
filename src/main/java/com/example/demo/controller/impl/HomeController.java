package com.example.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.controller.EmployeeAccountController;
import com.example.demo.service.EmployeeAccountServiceImpl;

@Controller
public class HomeController implements EmployeeAccountController {
    @Autowired
    EmployeeAccountServiceImpl employeeAccountServiceImpl;

    @GetMapping("/")
    public String root() {
        return "home";
    }

    @GetMapping("/home")
    public String home() {

        return "home";
    }

    @GetMapping("/login")
    public String login() {
        employeeAccountServiceImpl.checkEncode();
        return "login";
    }
}