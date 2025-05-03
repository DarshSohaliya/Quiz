package com.example.Quiz.Repository;

import com.example.Quiz.Model.UserAnswerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepo extends JpaRepository<UserAnswerModel,Long> {
}
