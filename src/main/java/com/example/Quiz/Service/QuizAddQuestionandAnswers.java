package com.example.Quiz.Service;

import com.example.Quiz.Model.QuizQandA;
import com.example.Quiz.Repository.QuizAddQuestionandAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizAddQuestionandAnswers {
    @Autowired
    QuizAddQuestionandAnswer quizAddQuestionandAnswer;

    public ResponseEntity<?> AddQandAs(List<QuizQandA> quizQandAS) {
        try {
            quizAddQuestionandAnswer.saveAll(quizQandAS);
            return new ResponseEntity<>("Added SuccessFully",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Not Added SuccessFull",HttpStatus.BAD_REQUEST);
        }
    }
}
