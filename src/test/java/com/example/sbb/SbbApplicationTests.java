package com.example.sbb;

import java.util.Optional;

import com.example.sbb.DTO.QuestionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {
        /*insert data
        QuestionDTO q1 = new QuestionDTO();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        QuestionDTO q2 = new QuestionDTO();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장
        */

        //findByID
        Optional<QuestionDTO> oq = this.questionRepository.findById(1);
        if(oq.isPresent()){
            QuestionDTO q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
        //findBySubject
        QuestionDTO oq2 = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, oq2.getId());

        //findBySubjectAndContent
        QuestionDTO oq3 = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, oq3.getId());

        //findBySubjectLike
        List<QuestionDTO> oq4 = this.questionRepository.findBySubjectLike("sbb%");
        QuestionDTO question = oq4.get(0);
        assertEquals("sbb에 대해서 알고 싶습니다.", question.getContent());

        //update data
        Optional<QuestionDTO> oq5 = this.questionRepository.findById(1);
        assertTrue(oq5.isPresent());
        QuestionDTO q = oq5.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }
}
