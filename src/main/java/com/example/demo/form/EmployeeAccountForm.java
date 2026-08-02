package com.example.demo.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeAccountForm implements Serializable {
    private Integer id;
    private Integer employeeId;
    private String name;
    private String password;
}
