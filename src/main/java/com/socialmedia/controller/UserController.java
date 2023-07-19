package com.socialmedia.controller;

import com.socialmedia.domain.Post;
import com.socialmedia.domain.User;
import com.socialmedia.service.PostService;
import com.socialmedia.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final PostService postService;

    @GetMapping
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public EntityModel<User> getUser(@PathVariable Integer id) {
        User user = service.findUser(id);
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable Integer id) {
        User user = service.findUser(id);
        return user.getPosts();
    }

    @PostMapping("{id}/posts")
    public ResponseEntity<User> createPostForUser(@PathVariable Integer id,
                                                  @Valid @RequestBody Post post) {
        Post savedPost = postService.createPost(id, post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
