package com.thoughtworks.repository;

import com.thoughtworks.entity.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerRepositoryTest {

    @Resource
    private AnswerRepository answerRepository;

    @Test
    public void should_get_last_answer_for_examineeId() {
        answerRepository.save(Answer.builder().content("a b c").examId("1").examineeId("1").build());
        answerRepository.save(Answer.builder().content("b c d").examId("1").examineeId("1").build());

        Answer answer = answerRepository.findByExamIdAndExamineeId("1", "1").get();
        assertEquals("b c d", answer.getContent());

    }
}
