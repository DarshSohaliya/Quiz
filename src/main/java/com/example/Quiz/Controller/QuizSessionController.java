package com.example.Quiz.Controller;

import com.example.Quiz.Model.QuizSession;
import com.example.Quiz.Repository.QuizSessionRepository;
import com.example.Quiz.Service.QuizSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/quiz")
public class QuizSessionController {

    @Autowired
    QuizSessionService quizSessionService;

    @PostMapping("/start")
    public ResponseEntity<?> StartQuiz(@RequestBody  String mobileNumber,int totalQuetion){

       QuizSession quizSession = quizSessionService.QuizStart(mobileNumber,totalQuetion);
        Map<String,Object> response =  new HashMap<>();
        response.put("QuizSession",quizSession.getSessionId());
        response.put("Message","Quiz Start");
        response.put("TotalQuestion",quizSession.getTotalQuetions());
        return ResponseEntity.ok(response);
    }
}
