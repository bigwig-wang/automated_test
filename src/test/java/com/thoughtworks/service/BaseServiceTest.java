package com.thoughtworks.service;

import com.thoughtworks.repository.UserRepository;
import com.thoughtworks.service.UserService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class BaseServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }
}
