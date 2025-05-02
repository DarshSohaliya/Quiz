package com.example.Quiz.Repository;

import com.example.Quiz.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByMobilerNumber(String mobileNumber);
}
