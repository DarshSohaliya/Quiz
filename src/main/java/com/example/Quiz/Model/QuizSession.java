package com.example.Quiz.Model;

import jakarta.persistence.*;

@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sessionId;

    @ManyToOne
   private User user;

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTotalQuetions() {
        return totalQuetions;
    }

    public void setTotalQuetions(int totalQuetions) {
        this.totalQuetions = totalQuetions;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    private int totalQuetions;

    private boolean isCompleted;
}
