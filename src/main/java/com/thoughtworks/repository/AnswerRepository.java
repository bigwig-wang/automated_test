package com.thoughtworks.repository;

import com.thoughtworks.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, String> {

    Optional<Answer> findByExamIdAndExamineeId(String examId, String examineeId);
}
