package com.example.Quiz.Controller;

import com.example.Quiz.Model.QuizQandA;
import com.example.Quiz.Service.QuizAddQuestionandAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class AddQuizAnswerandQuestion {

    @Autowired
    QuizAddQuestionandAnswers quizAddQuestionandAnswer;

    @PostMapping("/add")
    public ResponseEntity<?> AddQandA(@RequestBody List<QuizQandA> quizQandAS){
       return quizAddQuestionandAnswer.AddQandAs(quizQandAS);
    }
}
