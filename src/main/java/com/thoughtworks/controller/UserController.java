package com.thoughtworks.controller;

import com.thoughtworks.dto.UserRequest;
import com.thoughtworks.dto.UserResponse;
import com.thoughtworks.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void saveUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
}
