package com.thoughtworks.api;

import com.thoughtworks.controller.ExamController;
import com.thoughtworks.entity.Answer;
import com.thoughtworks.service.ExamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExamController.class)
public class ExamControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ExamService examService;

    @Test
    public void should_submit_answer_successfully_first_time() throws Exception {
        String answer = "a b c";

        willDoNothing().given(examService).submitAnswer(answer, "1", "1");
        mvc.perform(post("/exams/{examId}/examinee/{examineeId}/answers",
                "1", "1").content(answer)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_submit_answer_successfully_second_time_for_same_examineeId() throws Exception {
        String answer = "b c d";

        willDoNothing().given(examService).submitAnswer(answer, "1", "1");
        mvc.perform(post("/exams/1/examinee/1/answers").content(answer)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_examinee_answer_successfully() throws Exception {
        Answer answer = Answer.builder()
                .examineeId("1")
                .examId("1")
                .content("b c d")
                .build();
        willReturn(answer).given(examService).findAnswerByExamineeId("1", "1");

        mvc.perform(get("/exams/1/examinee/1/answers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", is("b c d")));
    }
}
