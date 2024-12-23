package com.smartech.mapstructdemo.service;

import com.smartech.mapstructdemo.model.UserEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Map<Long, UserEntity> users = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public Optional<UserEntity> findById(long id) {
        return Optional.ofNullable(this.users.get(id));
    }

    public UserEntity create(UserEntity user) {
        user.setId((long) counter.incrementAndGet());
        this.users.put(user.getId(), user);
        return user;
    }
}
