package com.thoughtworks.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Grading {

    @Id
    private String id;
    private String grading;
    private String examId;
}
