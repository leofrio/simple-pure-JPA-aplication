package com.first.demo;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public User() {
        this.authToken=null;
        this.fpToken=null;
        this.waitingForFPRequest=false;
    }
    @Id
    private String registration;
    private String email;
    //added this just for learning purposes wont be used on final database
    @ManyToOne
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Column(name = "pword")
    private String password;
    private String authToken;
    private boolean waitingForFPRequest;
    private String fpToken;

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public boolean isWaitingForFPRequest() {
        return waitingForFPRequest;
    }

    public void setWaitingForFPRequest(boolean waitingForFPRequest) {
        this.waitingForFPRequest = waitingForFPRequest;
    }

    public String getFpToken() {
        return fpToken;
    }

    public void setFpToken(String fpToken) {
        this.fpToken = fpToken;
    }
}
