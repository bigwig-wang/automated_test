package com.thoughtworks.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Grade {
    @Id
    private String id;
    private String examineeId;
    private Double score;

}