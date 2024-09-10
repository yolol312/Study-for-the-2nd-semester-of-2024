package com.example.sbb;

import java.util.Optional;

import com.example.sbb.DTO.QuestionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {
        Optional<QuestionDTO> oq = this.questionRepository.findById(1);
        if(oq.isPresent()){
            QuestionDTO q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
        QuestionDTO oq2 = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, oq2.getId());

        QuestionDTO oq3 = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, oq3.getId());
    }
}
