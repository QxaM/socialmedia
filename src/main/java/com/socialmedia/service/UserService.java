package com.socialmedia.service;

import com.socialmedia.domain.User;
import com.socialmedia.domain.exception.UserNotFoundException;
import com.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findUser(Integer userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " was not found!"));
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void deleteById(Integer userId) {
        repository.deleteById(userId);
    }
}
