package com.example.Quiz.Service;

import com.example.Quiz.Model.UserModel;
import com.example.Quiz.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public ResponseEntity<?> CreateUser(UserModel userModel) {
        try{
           UserModel user =  userRepo.save(userModel);
           return  new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
    }
}
