package com.example.sbb.Answer;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerDTO, Integer> {
}
