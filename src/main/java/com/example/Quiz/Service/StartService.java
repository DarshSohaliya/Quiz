package com.example.Quiz.Service;

import com.example.Quiz.DTO.QuizStartDTO;
import com.example.Quiz.Model.QuizSessionModel;
import com.example.Quiz.Model.UserModel;
import com.example.Quiz.Repository.QuizSessionRepo;
import com.example.Quiz.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StartService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    QuizSessionRepo quizSessionRepo;

    public ResponseEntity<?> StartQuiz(QuizStartDTO quiz) {
      UserModel user =  userRepo.findByMobileNumber(quiz.getMobileNumber());
      if(user == null){
          throw new RuntimeException("User Not Found");
      }
        QuizSessionModel quizSessionModel = new QuizSessionModel();
        quizSessionModel.setUserModel(user);
        quizSessionModel.setTotalQuestions(quiz.getTotalQuetion());
        quizSessionModel.setCurrentIndex(0);
        quizSessionModel.setCompleted(false);

        quizSessionRepo.save(quizSessionModel);

        return ResponseEntity.ok(quizSessionModel);


    }
}
