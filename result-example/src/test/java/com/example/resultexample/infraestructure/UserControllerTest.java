package com.example.resultexample.infraestructure;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;


    @Test
    void should_be_ok_when_creating_user(){
        UserRequest userRequest = new UserRequest("username", "password", "email");

        var response = userController.createUser(userRequest);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(Objects.nonNull(response.getBody()));
        assertEquals("username", response.getBody().getUsername());
        assertEquals("password", response.getBody().getPassword());
        assertEquals("email", response.getBody().getEmail());
    }

    @Test
    void should_be_internal_server_error_when_creating_user_with_invalid_email(){
        UserRequest userRequest = new UserRequest("username", "password", null);

        var response = userController.createUser(userRequest);

        assertEquals(500, response.getStatusCode().value());
    }

    @Test
    void should_be_not_found_when_creating_user_with_invalid_password(){
        UserRequest userRequest = new UserRequest("username", null, "email");

        var response = userController.createUser(userRequest);

        assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void should_be_bad_request_when_creating_user_with_invalid_username(){
        UserRequest userRequest = new UserRequest(null, "password", "email");

        var response = userController.createUser(userRequest);

        assertEquals(400, response.getStatusCode().value());
    }
}