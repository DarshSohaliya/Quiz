package com.example.Quiz.Repository;

import com.example.Quiz.Model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<QuestionModel,Long> {
}
