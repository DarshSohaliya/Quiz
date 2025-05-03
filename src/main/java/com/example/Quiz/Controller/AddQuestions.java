package com.example.Quiz.Controller;

import com.example.Quiz.Model.QuestionModel;
import com.example.Quiz.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class AddQuestions {

    @Autowired
    QuestionRepo questionRepo;

    @PostMapping("/add")
    public ResponseEntity<?> AddQandA(@RequestBody List<QuestionModel> questionModelList){
        questionRepo.saveAll(questionModelList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
