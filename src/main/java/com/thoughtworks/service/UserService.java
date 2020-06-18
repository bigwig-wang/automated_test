package com.thoughtworks.service;

import com.thoughtworks.dto.UserRequest;
import com.thoughtworks.dto.UserResponse;
import com.thoughtworks.entity.User;
import com.thoughtworks.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(user -> UserResponse.builder().name(user.getName()).build()).collect(Collectors.toList());
    }

    public void saveUser(UserRequest userRequest) {
        User user = User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .build();

        userRepository.save(user);
    }
}
