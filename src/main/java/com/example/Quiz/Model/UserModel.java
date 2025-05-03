package com.example.Quiz.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String MobileNumber) {
        mobileNumber = MobileNumber;
    }

    public int getTotalQuetion() {
        return totalQuetion;
    }

    public void setTotalQuetion(int totalQuetion) {
        this.totalQuetion = totalQuetion;
    }

    private String Name;
    private String mobileNumber;
    private int totalQuetion;
}
