package com.example.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.sbb.DataNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionDTO> getList(){
        return this.questionRepository.findAll();
    }

    public QuestionDTO getQuestion(Integer id){
        Optional<QuestionDTO> question = this.questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void insertQuestion(String subject, String content){
        QuestionDTO question = new QuestionDTO();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
}
