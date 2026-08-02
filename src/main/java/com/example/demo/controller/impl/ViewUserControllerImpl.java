package com.example.demo.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.UserController;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/list")
public class ViewUserControllerImpl implements UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String viewUser(Model model) {
        List<User> users = userService.selectAll();
        model.addAttribute("users", users);
        return "list";
    }
}
