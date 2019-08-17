package ru.roland.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.roland.server.models.dto.CreateUserDto;

import javax.validation.Valid;

@RestController
@Validated
public class UsersController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping(value = "/apiv1/users/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        jdbcTemplate.update("INSERT INTO users VALUES (?, ?, ?)",
                createUserDto.getId(), createUserDto.getLogin(), createUserDto.getEmail());
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
