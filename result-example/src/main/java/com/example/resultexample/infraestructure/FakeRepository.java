package com.example.resultexample.infraestructure;

import com.example.resultexample.domain.User;
import com.example.resultexample.domain.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FakeRepository implements UserRepository {

    @Override
    public void save(User user) {

    }
}
