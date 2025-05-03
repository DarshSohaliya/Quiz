package com.example.Quiz.Controller;

import com.example.Quiz.DTO.QuizStartDTO;
import com.example.Quiz.Service.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/quiz")
public class StarController {

    @Autowired
    StartService startService;

    @PostMapping("/start")
    public ResponseEntity<?> StartQuiz(@RequestBody QuizStartDTO quiz){
        return startService.StartQuiz(quiz);
    }

}
