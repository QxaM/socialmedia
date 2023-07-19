package com.socialmedia.repository;

import com.socialmedia.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();
}
