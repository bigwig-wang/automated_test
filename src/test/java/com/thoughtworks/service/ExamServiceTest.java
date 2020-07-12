package com.thoughtworks.service;


import com.thoughtworks.entity.Answer;
import com.thoughtworks.entity.User;
import com.thoughtworks.repository.AnswerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.any;

@Import(BaseServiceTest.class)
@RunWith(SpringRunner.class)
public class ExamServiceTest {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ExamService examService;

    @Test
    public void should_submit_answer_successfully_first() {

        willReturn(Optional.empty()).given(answerRepository).findByExamIdAndExamineeId("1", "1");
        examService.submitAnswer("a b c", "1", "1");

        Mockito.verify(answerRepository, Mockito.times(1)).save(any(Answer.class));
    }

    @Test
    public void should_submit_answer_successfully_second() {

        willReturn(Optional.empty()).given(answerRepository).findByExamIdAndExamineeId("1", "1");
        examService.submitAnswer("a b c", "1", "1");
        examService.submitAnswer("b c d", "1", "1");

        Mockito.verify(answerRepository, Mockito.times(2)).save(any(Answer.class));
    }

    @Test
    public void should_get_last_answer_successfully() {
        Answer answer = Answer.builder().content("b c d").examId("1").examineeId("1").build();

        willReturn(Optional.of(answer)).given(answerRepository).findByExamIdAndExamineeId("1", "1");
        Answer answer1 = examService.findAnswerByExamineeId("1", "1");

        Mockito.verify(answerRepository, Mockito.times(1)).findByExamIdAndExamineeId("1", "1");
        assertEquals("b c d", answer1.getContent());
    }

}
