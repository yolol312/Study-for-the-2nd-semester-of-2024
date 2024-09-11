package com.example.sbb.Question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionDTO, Integer> {
    QuestionDTO findBySubject(String subject);
    QuestionDTO findBySubjectAndContent(String subject, String content);
    List<QuestionDTO> findBySubjectLike(String subject);
}

