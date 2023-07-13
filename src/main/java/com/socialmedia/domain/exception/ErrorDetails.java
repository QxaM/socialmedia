package com.socialmedia.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class ErrorDetails {
    private final LocalDate timestamp;
    private final String message;
    private final String details;
}
