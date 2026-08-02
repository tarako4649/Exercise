package com.example.demo.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeAccountTest {

    @Test
    public void testGetterSetter_case1() {

        EmployeeAccount account = new EmployeeAccount();

        account.setEmployeeId(1);
        account.setName("tarako");
        account.setPassword("password");

        assertEquals(1, account.getEmployeeId());
        assertEquals("tarako", account.getName());
        assertEquals("password", account.getPassword());
    }
}