package com.thoughtworks.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer {

    @Id
    private String id;
    private String content;
    private String examId;
    private String examineeId;
    private LocalDateTime submittedAt;
}
