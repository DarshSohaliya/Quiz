package com.example.Quiz.Controller;

import com.example.Quiz.Service.NextQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/quiz")
public class NextQuestionController {

    @Autowired
    NextQuestionService nextQuestionService;

    @GetMapping("/next")
    public ResponseEntity<?> Nextquestion(@RequestParam Long sessionId){
        return nextQuestionService.NextQuestion(sessionId);
    }
}
