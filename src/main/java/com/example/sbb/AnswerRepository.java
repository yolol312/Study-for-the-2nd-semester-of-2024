package com.example.sbb;


import com.example.sbb.DTO.AnswerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerDTO, Integer> {
}
