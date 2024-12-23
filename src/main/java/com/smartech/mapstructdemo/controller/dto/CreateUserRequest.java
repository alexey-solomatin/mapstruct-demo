package com.smartech.mapstructdemo.controller.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String fullName;
    private String email;
    private int age;
}
