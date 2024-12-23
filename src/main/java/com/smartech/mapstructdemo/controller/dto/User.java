package com.smartech.mapstructdemo.controller.dto;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String displayName;
    private int age;
}
