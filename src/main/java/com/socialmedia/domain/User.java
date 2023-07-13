package com.socialmedia.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class User {
    private final Integer id;
    private final String name;
    private final LocalDate birthDate;
}
