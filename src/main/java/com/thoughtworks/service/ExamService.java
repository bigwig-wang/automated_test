package com.thoughtworks.service;

import com.thoughtworks.entity.Answer;
import com.thoughtworks.repository.AnswerRepository;
import com.thoughtworks.repository.ExamRepository;
import com.thoughtworks.repository.ExamineeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final AnswerRepository answerRepository;
    private final ExamineeRepository examineeRepository;
    private final ExamRepository examRepository;

    public void submitAnswer(String answer, String examId, String examineeId) {
        //查询考试是否存在，查询考生是否属于这场考试
        Optional<Answer> existedAnswer = answerRepository.findByExamIdAndExamineeId(examId, examineeId);

        Answer an = Answer.builder()
                .content(answer)
                .examineeId(examineeId)
                .examId(examId)
                .submittedAt(LocalDateTime.now())
                .build();

        if (existedAnswer.isPresent()) {
            BeanUtils.copyProperties(an, existedAnswer, "id");
        }
        answerRepository.save(an);
    }

    public Answer findAnswerByExamineeId(String examId, String examineeId) {
        return answerRepository.findByExamIdAndExamineeId(examId, examineeId).get();
    }

    public void eidt(String examId, int interval) {

    }
}
