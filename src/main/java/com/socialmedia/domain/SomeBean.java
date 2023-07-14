package com.socialmedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SomeBean {
    private final String field1;
    @JsonIgnore
    private final String field2;
    private final String field3;
}
