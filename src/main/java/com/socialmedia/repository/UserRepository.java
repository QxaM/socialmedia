package com.socialmedia.repository;

import com.socialmedia.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();
}
