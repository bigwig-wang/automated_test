package com.thoughtworks.controller;

import com.thoughtworks.entity.Answer;
import com.thoughtworks.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping("/{examId}/examinee/{examineeId}/answers")
    public void submitAnswer(@PathVariable("examId") String examId,
                             @PathVariable("examineeId") String examineeId,
                             String answer) {
        examService.submitAnswer(answer, examId, examineeId);
    }

    @GetMapping("/{examId}/examinee/{examineeId}/answers")
    public Answer getAnswer(@PathVariable("examId") String examId,
                            @PathVariable("examineeId") String examineeId) {
        return examService.findAnswerByExamineeId(examId, examineeId);
    }

    @PutMapping("/{examId}")
    public void updateExam(@PathVariable String examId, int interval) {
        examService.eidt(examId, interval);
    }
}
