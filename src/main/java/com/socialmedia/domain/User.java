package com.socialmedia.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Size(min=2, message = "Name should have at least 2 characters")
    @JsonProperty("user_name")
    @Column(name = "USER_NAME")
    private String name;

    @Past(message = "Birth Date should be in the past")
    @JsonProperty("birth_date")
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
}
