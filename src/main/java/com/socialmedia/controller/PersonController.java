package com.socialmedia.controller;

import com.socialmedia.domain.PersonV1;
import com.socialmedia.domain.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(path = "person", params = "version=1")
    public PersonV1 getPersonParamV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "person", params = "version=2")
    public PersonV2 getPersonParamV2() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(path = "person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonHeaderV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonHeaderV2() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(path = "person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonAcceptV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonAcceptV2() {
        return new PersonV2("Bob", "Charlie");
    }
}
