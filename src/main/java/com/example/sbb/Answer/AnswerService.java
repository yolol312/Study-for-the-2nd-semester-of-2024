package com.example.sbb.Answer;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import com.example.sbb.Question.QuestionDTO;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void insertAnswer(String content, QuestionDTO question) {
        AnswerDTO answer = new AnswerDTO();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}
