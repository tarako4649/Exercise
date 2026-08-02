package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
