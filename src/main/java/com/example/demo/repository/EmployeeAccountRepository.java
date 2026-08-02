package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.EmployeeAccount;
import com.example.demo.entity.User;

@Mapper
public interface EmployeeAccountRepository {

    List<User> selectAll();

    void create(EmployeeAccount employeeAccount);
}
