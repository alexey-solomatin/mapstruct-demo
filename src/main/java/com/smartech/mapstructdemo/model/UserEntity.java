package com.smartech.mapstructdemo.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UserEntity {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Gender gender;
    private Status status;


    public enum Status {
        ACTIVE,
        BLOCKED
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
