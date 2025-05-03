package com.example.Quiz.Repository;

import com.example.Quiz.Model.UserAnswerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAnswerRepo extends JpaRepository<UserAnswerModel,Long> {
    List<UserAnswerModel> findBysessionId(Long sessionId);
}
