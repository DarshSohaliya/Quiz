package com.example.Quiz.Service;

import com.example.Quiz.DTO.QuizStartDTO;
import com.example.Quiz.Model.QuestionModel;
import com.example.Quiz.Model.QuizSessionModel;
import com.example.Quiz.Repository.QuestionRepo;
import com.example.Quiz.Repository.QuizSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NextQuestionService {
    @Autowired
    QuizSessionRepo quizSessionRepo;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<?> NextQuestion(Long sessionId) {
        QuizSessionModel quizSessionModel=  quizSessionRepo.findBysessionId(sessionId);
        if(quizSessionModel == null){
            throw  new RuntimeException("Session Not Found");
        }

        if (quizSessionModel.isCompleted()) {
            return ResponseEntity.ok("Quiz Already Completed");
        }

        int currentIndex = quizSessionModel.getCurrentIndex();;
        int totalQuestions = quizSessionModel.getTotalQuestions();

        List<QuestionModel>  allQuestions = questionRepo.findAll();
System.out.println(allQuestions);
        if (allQuestions.size() == 0 || currentIndex >= totalQuestions){
            quizSessionModel.setCompleted(true);
            quizSessionRepo.save(quizSessionModel);
            return ResponseEntity.ok("Quiz Completed");
        }
        QuestionModel currentQuestion = allQuestions.get(currentIndex);
        quizSessionModel.setCurrentIndex(currentIndex + 1);
        quizSessionRepo.save(quizSessionModel);

        return ResponseEntity.ok(currentQuestion);
    }
}
