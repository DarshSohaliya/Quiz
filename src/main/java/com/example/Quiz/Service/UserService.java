package com.example.Quiz.Service;

import com.example.Quiz.Model.User;
import com.example.Quiz.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public ResponseEntity<?> Createuser(User user) {
        try {
            userRepository.save(user);
            return new ResponseEntity<>("User Created SuccessFully",HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>("User not Created SuccessFully", HttpStatus.BAD_REQUEST);
        }
    }
}
