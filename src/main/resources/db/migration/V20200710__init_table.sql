create table user
(
    id   VARCHAR(32) NOT NUll PRIMARY KEY,
    name VARCHAR(32) NOT NULL
);

create table exam
(
    id   VARCHAR(32) NOT NUll PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    `interval` INT NOT NULL
);

create table examinee
(
    id   VARCHAR(32) NOT NUll PRIMARY KEY,
    userId VARCHAR(32) NOT NULL,
    examId VARCHAR(32) NOT NULL,
    CONSTRAINT fk_examinee_userId FOREIGN KEY(userId) REFERENCES user(id),
    CONSTRAINT fk_examinee_examId FOREIGN KEY(examId) REFERENCES exam(id)
);

create table grade
(
    id   VARCHAR(32) NOT NUll PRIMARY KEY,
    examId VARCHAR(32) NOT NULL,
    score NUMERIC NOT NULL,
    CONSTRAINT fk_grade_examId FOREIGN KEY(examId) REFERENCES exam(id)
);

create table grading
(
    id   VARCHAR(32) NOT NUll PRIMARY KEY,
    examId VARCHAR(32) NOT NULL,
    grading text,
    CONSTRAINT fk_grading_examId FOREIGN KEY(examId) REFERENCES exam(id)
);

create table answer
(
    id   VARCHAR(32) NOT NUll PRIMARY KEY,
    content TEXT NOT NULL,
    examId VARCHAR(32) NOT NUll,
    examineeId VARCHAR(32) NOT NUll,
    submittedAt DATETIME,
    CONSTRAINT fk_answer_examId FOREIGN KEY(examId) REFERENCES exam(id),
    CONSTRAINT fk_answer_examineeId FOREIGN KEY(examineeId) REFERENCES examinee(id)
);



