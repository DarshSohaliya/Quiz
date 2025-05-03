package com.example.Quiz.Repository;

import com.example.Quiz.Model.QuizSessionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizSessionRepo extends JpaRepository<QuizSessionModel,Long> {
    QuizSessionModel findBysessionId(Long sessionId);

}
