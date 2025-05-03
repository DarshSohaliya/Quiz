package com.example.Quiz.Controller;

import com.example.Quiz.DTO.AnswerRequestDTO;
import com.example.Quiz.Model.QuizSessionModel;
import com.example.Quiz.Repository.QuizSessionRepo;
import com.example.Quiz.Repository.UserAnswerRepo;
import com.example.Quiz.Service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/quiz")
public class SubmitController {

    @Autowired
    UserAnswerRepo userAnswerRepo;

    @Autowired
    SubmitService submitService;

    @Autowired
    QuizSessionRepo quizSessionRepo;

    @PostMapping("/submit")
    public ResponseEntity<?> SubmitAnswer(@RequestParam Long sessionId, @RequestBody AnswerRequestDTO answerRequestDTO){
        QuizSessionModel quizSessionModel = quizSessionRepo.findBysessionId(sessionId);
        if(quizSessionModel == null){
            throw  new RuntimeException("Seesion Invalid");
        }

       return submitService.SubmitAns(sessionId,answerRequestDTO);
    }
}
