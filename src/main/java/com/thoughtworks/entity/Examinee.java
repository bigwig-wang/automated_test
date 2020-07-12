package com.thoughtworks.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Examinee {

    @Id
    private String id;
    private String userId;
    private String examId;
}
