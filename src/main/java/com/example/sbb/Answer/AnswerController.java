package com.example.sbb.Answer;
import com.example.sbb.Question.QuestionDTO;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final AnswerService answerService;

    public void insertAnswer (String content, QuestionDTO question) {
        this.answerService.insertAnswer(content, question);
    }

}
