package com.example.Quiz.Service;

import com.example.Quiz.DTO.AnswerRequestDTO;
import com.example.Quiz.Model.QuestionModel;
import com.example.Quiz.Model.QuizSessionModel;
import com.example.Quiz.Model.UserAnswerModel;
import com.example.Quiz.Repository.QuestionRepo;
import com.example.Quiz.Repository.QuizSessionRepo;
import com.example.Quiz.Repository.UserAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubmitService {
    @Autowired
    UserAnswerRepo userAnswerRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    QuizSessionRepo quizSessionRepo;
    public ResponseEntity<?> SubmitAns(Long sessionId,AnswerRequestDTO answerRequestDTO) {

        QuizSessionModel quizSessionModel = quizSessionRepo.findBysessionId(sessionId);
        if (quizSessionModel == null) {
            return ResponseEntity.badRequest().body("Invalid session ID");
        }

        int currentIndex = quizSessionModel.getCurrentIndex();
        int totalQuestions = quizSessionModel.getTotalQuestions();

        // Check if the current index is equal to or greater than the total questions, meaning quiz is completed
        if (currentIndex >= totalQuestions) {
            return ResponseEntity.badRequest().body("Quiz is already completed, no more answers can be submitted.");
        }


        Optional<QuestionModel> questionModel = questionRepo.findById(answerRequestDTO.getQuestionId());
        if (questionModel == null) {
            return ResponseEntity.badRequest().body("Invalid question ID");
        }
        QuestionModel question = questionModel.get();
        String correctAnswer = question.getAnswer();

        boolean isCorrect = correctAnswer.equalsIgnoreCase(answerRequestDTO.getSelectedOption());


        UserAnswerModel userAnswerModel  = new UserAnswerModel();
        userAnswerModel.setSessionId(sessionId);
        userAnswerModel.setQuestionId(answerRequestDTO.getQuestionId());
        userAnswerModel.setSelectedAnswer(answerRequestDTO.getSelectedOption());
        userAnswerModel.setCorrect(isCorrect);

        userAnswerRepo.save(userAnswerModel);

        return new ResponseEntity<>("Answer Submited SuccessFully", HttpStatus.OK);
    }
}
