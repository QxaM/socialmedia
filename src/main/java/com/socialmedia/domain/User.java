package com.socialmedia.domain;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class User {
    private final Integer id;
    @Size(min=2, message = "Name should have at least 2 characters")
    private final String name;
    @Past(message = "Birth Date should be in the past")
    private final LocalDate birthDate;
}
