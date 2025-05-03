package com.example.Quiz.Repository;

import com.example.Quiz.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel,Long> {
    UserModel findByMobileNumber(String mobileNumber);

}
