package com.example.Quiz.Repository;

import com.example.Quiz.Model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer,Long> {
    List<UserAnswer> findBySessionId(Long sessionId);
}
