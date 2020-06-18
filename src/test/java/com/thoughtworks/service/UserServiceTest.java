package com.thoughtworks.service;


import com.thoughtworks.dto.UserRequest;
import com.thoughtworks.dto.UserResponse;
import com.thoughtworks.entity.User;
import com.thoughtworks.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

@Import(BaseServiceTest.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_save_user_successfully() {
        UserRequest userRequest = UserRequest.builder()
                .id("1")
                .name("name")
                .build();
        User user = User.builder()
                .id("1")
                .name("name")
                .build();
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        userService.saveUser(userRequest);
        Mockito.verify(userRepository, Mockito.times(1)).save(any(User.class));

    }

    @Test
    public void should_get_user_successfully() {
        List<User> userList = Arrays.asList(User.builder().id("1").name("1").build(),
                User.builder().id("2").name("2").build());
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        List<UserResponse> users = userService.getUsers();

        assertEquals(users.size(), 2);

    }
}
