package com.thoughtworks.repository;

import com.thoughtworks.entity.Examinee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamineeRepository extends JpaRepository<Examinee, String> {
}
