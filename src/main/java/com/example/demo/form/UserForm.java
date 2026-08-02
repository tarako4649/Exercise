package com.example.demo.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserForm implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
