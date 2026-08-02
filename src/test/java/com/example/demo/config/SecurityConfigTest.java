package com.example.demo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SecurityConfigTest {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void generateHash() {
        System.out.println(passwordEncoder.encode("password"));
    }
}
