package com.example.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.EmployeeAccountController;
import com.example.demo.entity.EmployeeAccount;
import com.example.demo.service.EmployeeAccountServiceImpl;

@Controller
public class RegisterController implements EmployeeAccountController {

    @Autowired
    private EmployeeAccountServiceImpl employeeAccountService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(EmployeeAccount account) {
        employeeAccountService.create(account);
        return "redirect:/login?registered";
    }
}
