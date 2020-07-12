package com.thoughtworks.service;

import com.thoughtworks.repository.AnswerRepository;
import com.thoughtworks.repository.ExamRepository;
import com.thoughtworks.repository.ExamineeRepository;
import com.thoughtworks.repository.UserRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class BaseServiceTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AnswerRepository answerRepository;

    @MockBean
    private ExamineeRepository examineeRepository;

    @MockBean
    private ExamRepository examRepository;

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }

    @Bean
    public ExamService examService() {
        return new ExamService(answerRepository, examineeRepository, examRepository);
    }
}
