package ru.roland.server.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.roland.server.models.dto.CreateUserDto;

import java.util.Arrays;

public class UsersDao extends BaseDao {

    public UsersDao(JdbcTemplate jdbcTemplate) {
        super("users", jdbcTemplate);
    }

    public void addUser(CreateUserDto createUserDto) {
        simpleInsert(Arrays.asList("login", "email"), Arrays.asList(createUserDto.getLogin(), createUserDto.getEmail()));
    }

}
