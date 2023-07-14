package com.socialmedia.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private final String field1;
    private final String field2;
    private final String field3;
}
