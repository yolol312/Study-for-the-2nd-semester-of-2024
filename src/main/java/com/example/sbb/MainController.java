package com.example.sbb;

import com.example.sbb.Answer.AnswerController;
import com.example.sbb.Question.QuestionController;
import com.example.sbb.Question.QuestionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final QuestionController questionController;
    private final AnswerController answerController;

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

    @PostMapping(value = "/answer/create/{id}")
    public String answerInsert(@PathVariable("id") Integer id, @RequestParam(value="content") String content) {
        QuestionDTO question = this.questionController.getQuestion(id);
        this.answerController.insertAnswer(content, question);
        return String.format("redirect:/question/detail/%s", id);
    }
}
