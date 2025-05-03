package com.example.Quiz.Service;

import com.example.Quiz.Model.QuizSessionModel;
import com.example.Quiz.Model.UserAnswerModel;
import com.example.Quiz.Repository.QuizSessionRepo;
import com.example.Quiz.Repository.UserAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    UserAnswerRepo userAnswerRepo;

    @Autowired
    QuizSessionRepo quizSessionRepo;
    public ResponseEntity<?> GetResult(Long sessionId) {

        QuizSessionModel quizSessionModel = quizSessionRepo.findBysessionId(sessionId);
        if(quizSessionModel == null){
            return ResponseEntity.badRequest().body("Invalid session ID");
        }

        List<UserAnswerModel> answers = userAnswerRepo.findBysessionId(sessionId);



        if(answers.isEmpty()){
            return ResponseEntity.badRequest().body("No answersfound for session");
        }

        int totalQuestions = quizSessionModel.getTotalQuestions();
        if (answers.size() < totalQuestions) {
            return ResponseEntity.badRequest().body("Please complete all questions before viewing result");
        }

        long totalQuestion  = answers.size();
        long correctAnswers = answers.stream().filter(UserAnswerModel::isCorrect).count();

        return ResponseEntity.ok("Correct Answers : " + correctAnswers + "out of : " +  totalQuestion);

    }
}
