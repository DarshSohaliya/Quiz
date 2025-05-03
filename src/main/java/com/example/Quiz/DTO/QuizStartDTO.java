package com.example.Quiz.DTO;

public class QuizStartDTO {


    private String mobileNumber;
    private int totalQuestions;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getters and Setters
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getTotalQuetion() {
        return totalQuestions;
    }

    public void setTotalQuetion(int totalQuetion) {
        this.totalQuestions= totalQuetion;
    }
}
