package com.example.Quiz.Controller;


import com.example.Quiz.Model.UserModel;
import com.example.Quiz.Repository.UserRepo;
import com.example.Quiz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/quiz")
public class UserController {

    @Autowired
    UserService userService;


  @PostMapping("/create-user")
    public ResponseEntity<?> CreateUser(@RequestBody UserModel userModel){
         return userService.CreateUser(userModel);
    }
}
