package com.thoughtworks.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Exam {

    @Id
    private String id;
    private String name;
    private Long interval;

}
