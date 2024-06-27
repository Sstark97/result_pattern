package com.example.resultexample.infraestructure;

import com.example.resultexample.application.CreateUserCommand;
import com.example.resultexample.application.UserCreator;
import com.example.resultexample.domain.CreateUserResult;
import com.example.resultexample.domain.Error;
import com.example.resultexample.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserCreator userCreator;

    public UserController(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        CreateUserResult createUserResult = userCreator.execute(
                new CreateUserCommand(userRequest.username(), userRequest.password(), userRequest.email())
        );
        if(createUserResult.isFailure()){
            if(createUserResult.getError() instanceof Error.InvalidUsername){
                return ResponseEntity.badRequest().build();
            }
            if(createUserResult.getError() instanceof Error.InvalidPassword){
                return ResponseEntity.notFound().build();
            }
            if(createUserResult.getError() instanceof Error.InvalidEmail){
                return ResponseEntity.internalServerError().build();
            }
        }
        return ResponseEntity.ok(createUserResult.getUser());
    }
}
