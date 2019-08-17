package ru.roland.server.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.roland.server.dao.UsersDao;

@Configuration
@ComponentScan("ru.roland.server.dao")
public class DaoConfig {

    @Bean
    public UsersDao usersDao(JdbcTemplate jdbcTemplate) {
        return new UsersDao(jdbcTemplate);
    }

}
