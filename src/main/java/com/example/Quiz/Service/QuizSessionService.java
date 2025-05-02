package com.example.Quiz.Service;

import com.example.Quiz.Controller.UserController;
import com.example.Quiz.Model.QuizSession;
import com.example.Quiz.Model.User;
import com.example.Quiz.Repository.QuizSessionRepository;
import com.example.Quiz.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizSessionService {

    @Autowired
    UserRepository userRepository;

     @Autowired
    QuizSessionRepository quizSessionRepository;

    public QuizSession QuizStart(String MobileNumber,int totalQuetion){
        User user  = userRepository.findByMobilerNumber(MobileNumber);
        if(user == null){
            throw new RuntimeException("User Not Found");
        }
        QuizSession quizSession  = new QuizSession();
        quizSession.setUser(user);
        quizSession.setTotalQuetions(totalQuetion);
        return  quizSessionRepository.save(quizSession);
            }

}
