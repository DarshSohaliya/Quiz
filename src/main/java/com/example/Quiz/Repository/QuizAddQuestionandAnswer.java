package com.example.Quiz.Repository;

import com.example.Quiz.Model.QuizQandA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAddQuestionandAnswer extends JpaRepository<QuizQandA, Long> {

    QuizQandA findByquetionId(Long questionId);
}
