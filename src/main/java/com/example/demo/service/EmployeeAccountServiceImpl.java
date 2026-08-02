package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeAccount;
import com.example.demo.repository.EmployeeAccountRepository;

@Service
public class EmployeeAccountServiceImpl {
    @Autowired
    EmployeeAccountRepository employeeAccountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void create(EmployeeAccount employeeAccount) {
        String password = employeeAccount.getPassword();
        employeeAccount.setPassword(passwordEncoder.encode(password));
        employeeAccountRepository.create(employeeAccount);
    }

    public void checkEncode() {

        System.out.println(passwordEncoder.encode("test"));
    }

}
