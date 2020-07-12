package com.thoughtworks.repository;

import com.thoughtworks.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, String> {

}
