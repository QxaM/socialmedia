package com.socialmedia.service;

import com.socialmedia.domain.Post;
import com.socialmedia.domain.User;
import com.socialmedia.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;
    private final UserService userService;

    public Post createPost(Integer userId, Post post) {
        User foundUser = userService.findUser(userId);
        Post postToSave = new Post(
                post.getDescription(),
                foundUser
        );
        return repository.save(postToSave);
    }
}
