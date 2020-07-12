package com.thoughtworks.repository;

import com.thoughtworks.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, String> {
}
