package com.socialmedia.service;

import com.socialmedia.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final static List<User> users = new ArrayList<>();

    private static Integer userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(24)));
        users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findUser(Integer userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(new User(0, "", LocalDate.now()));
    }

    public User save(User user) {
        User newUser = new User(
                ++userCount,
                user.getName(),
                user.getBirthDate());
        users.add(newUser);
        return newUser;
    }
}
