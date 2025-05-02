package com.example.Quiz.Controller;

import com.example.Quiz.DTO.AnswerRequestDTO;
import com.example.Quiz.Model.UserAnswer;
import com.example.Quiz.Service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/quiz")
public class SubmitController {

    @Autowired
    UserAnswerService userAnswerService;

    @PostMapping("/submit")
    public ResponseEntity<?> SubmitAnswer(@PathVariable Long sessionId, @RequestBody AnswerRequestDTO answerRequestDTO){
      UserAnswer userAnswer = userAnswerService.Submit(sessionId,answerRequestDTO.getQuestionId(),answerRequestDTO.getSelectedOption());
        if (userAnswer == null) {
            return ResponseEntity.badRequest().body("Invalid question ID");
        }

        return ResponseEntity.ok("Answer submitted successfully");
    }
}
