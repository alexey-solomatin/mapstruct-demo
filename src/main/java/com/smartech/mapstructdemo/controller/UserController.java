package com.smartech.mapstructdemo.controller;

import com.smartech.mapstructdemo.controller.dto.CreateUserRequest;
import com.smartech.mapstructdemo.controller.dto.User;
import com.smartech.mapstructdemo.mapper.UserMapper;
import com.smartech.mapstructdemo.model.UserEntity;
import com.smartech.mapstructdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.of(
            this.userService.findById(id).map(this.userMapper::map));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
        // Logic to create a new user
        UserEntity userEntity = this.userService.create(
            this.userMapper.map(createUserRequest));
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.userMapper.map(userEntity));
    }
}
