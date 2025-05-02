package com.example.Quiz.Service;

import com.example.Quiz.Model.QuizQandA;
import com.example.Quiz.Model.UserAnswer;
import com.example.Quiz.Repository.QuizAddQuestionandAnswer;
import com.example.Quiz.Repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService {

    @Autowired
    UserAnswerRepository userAnswerRepository;

    @Autowired
    QuizAddQuestionandAnswer quizAddQuestionandAnswer;

    public UserAnswer Submit(Long sessionId, Long questionId, String selectedOption) {
         QuizQandA question =  quizAddQuestionandAnswer.findByquetionId(questionId);

         if(question == null){
              return null;
         }
         boolean isCorrect = question.getAnswer().equalsIgnoreCase(selectedOption);
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setIsaCorrect(isCorrect);
        userAnswer.setSessionId(sessionId);
        userAnswer.setQuestionId(questionId);
        userAnswer.setSelectedOption(selectedOption);
         return userAnswerRepository.save(userAnswer);


    }
}
