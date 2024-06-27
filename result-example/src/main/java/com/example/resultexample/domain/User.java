package com.example.resultexample.domain;

public class User {
    private final String username;
    private final String password;
    private final String email;

    private User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static CreateUserResult from(String username, String password, String email){
        if(username == null || username.isBlank()){
            return CreateUserResult.invalidUsername();
        }
        if(password == null || password.isBlank()){
             return CreateUserResult.invalidPassword();
        }
        if(email == null || email.isBlank()){
            return CreateUserResult.invalidEmail();
        }
        return CreateUserResult.success(new User(username, password, email));
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
