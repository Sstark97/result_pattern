package com.example.resultexample.domain;

public class CreateUserResult {
    private User user;
    private Error error;

    public User getUser() {
        return user;
    }

    public Error getError() {
        return error;
    }

    private CreateUserResult(User user, Error error) {
        this.user = user;
        this.error = error;
    }

    public boolean isSuccess(){
        return error == null;
    }

    public boolean isFailure(){
        return error != null;
    }

    public static CreateUserResult success(User user){
        return new CreateUserResult(user,null);
    }

    public static CreateUserResult invalidUsername(){
        return new CreateUserResult(null, new Error.InvalidUsername());
    }

    public static CreateUserResult invalidPassword(){
        return new CreateUserResult(null, new Error.InvalidPassword());
    }

    public static CreateUserResult invalidEmail(){
        return new CreateUserResult(null, new Error.InvalidEmail());
    }
}
