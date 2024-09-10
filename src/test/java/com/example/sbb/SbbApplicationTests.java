package com.example.sbb;

import java.util.Optional;

import com.example.sbb.DTO.AnswerDTO;
import com.example.sbb.DTO.QuestionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional //DB 섹션 유지
    @Test
    void testJpa() {
        /*
        //insert data
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

        //findByID
        Optional<QuestionDTO> oq = this.questionRepository.findById(1);
        if(oq.isPresent()){
            QuestionDTO q3 = oq.get();
            assertEquals("sbb가 무엇인가요?", q3.getSubject());
        }
        //findBySubject
        QuestionDTO oq2 = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, oq2.getId());

        //findBySubjectAndContent
        QuestionDTO oq3 = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, oq3.getId());

        //findBySubjectLike
        List<QuestionDTO> oq4 = this.questionRepository.findBySubjectLike("sbb%");
        QuestionDTO q4 = oq4.get(0);
        assertEquals("sbb에 대해서 알고 싶습니다.", q4.getContent());

        //update data
        Optional<QuestionDTO> oq5 = this.questionRepository.findById(1);
        assertTrue(oq5.isPresent());
        QuestionDTO q5 = oq5.get();
        q5.setSubject("수정된 제목");
        this.questionRepository.save(q5);

        //delete data
        Optional<QuestionDTO> oq6 = this.questionRepository.findById(1);
        assertTrue(oq6.isPresent());
        QuestionDTO q6 = oq6.get();
        this.questionRepository.delete(q6);
        assertEquals(1, this.questionRepository.count());


        //add answer data
        Optional<QuestionDTO> oq7 = this.questionRepository.findById(2);
        assertTrue(oq7.isPresent());
        QuestionDTO q7 = oq7.get();

        AnswerDTO a = new AnswerDTO();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q7);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
        */

        //select answer datas By question
        Optional<QuestionDTO> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        QuestionDTO q = oq.get();
        List<AnswerDTO> answerList = q.getAnswerList();


        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
}
