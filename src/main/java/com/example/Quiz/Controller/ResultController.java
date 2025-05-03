package com.example.Quiz.Controller;

import com.example.Quiz.Model.QuizSessionModel;
import com.example.Quiz.Repository.QuizSessionRepo;
import com.example.Quiz.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/quiz")
public class ResultController {
    @Autowired
    ResultService resultService;

    @Autowired
    QuizSessionRepo quizSessionRepo;

    @GetMapping("/result")
    public ResponseEntity<?> GetResult(@RequestParam Long sessionId){
         QuizSessionModel quizSessionModel =  quizSessionRepo.findBysessionId(sessionId);
         if(quizSessionModel == null ){
             return new ResponseEntity<>("Session is Not Valid", HttpStatus.BAD_REQUEST);
         }
         return resultService.GetResult(sessionId);
    }

}
