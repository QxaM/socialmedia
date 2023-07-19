package com.socialmedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "POSTS")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRIPTION")
    @Size(min = 10)
    private String description;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }
}
