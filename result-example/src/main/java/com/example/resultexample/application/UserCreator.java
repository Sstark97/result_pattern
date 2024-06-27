package com.example.resultexample.application;

import com.example.resultexample.domain.CreateUserResult;
import com.example.resultexample.domain.User;
import com.example.resultexample.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {
    private final UserRepository userRepository;

    public UserCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CreateUserResult execute(CreateUserCommand createUserCommand) {
        final CreateUserResult createUserResult = User.from(
            createUserCommand.username(),
            createUserCommand.password(),
            createUserCommand.email()
        );
        if(createUserResult.isSuccess()){
            userRepository.save(createUserResult.getUser());
        }
        return createUserResult;
    }
}
