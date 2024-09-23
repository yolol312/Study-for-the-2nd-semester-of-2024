package com.example.sbb.Question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model){
        List<QuestionDTO> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        QuestionDTO question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    @GetMapping("/insert")
    public String insertQuestion(){
        return "insert_question";
    }
    /* 검증이 없는 버전
    @PostMapping("/insert")
    public String writeQuestion(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
        this.questionService.insertQuestion(subject, content);
        return "redirect:/question/list";
    }
    */
    @PostMapping("/insert")
    public String writeQuestion(@Valid QuestionInsert quetionInsert, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "insert_question";
        }
        this.questionService.insertQuestion(quetionInsert.getSubject(), quetionInsert.getContent());
        return "redirect:/question/list";
    }

    public QuestionDTO getQuestion(Integer id){
        return this.questionService.getQuestion(id);
    }
}
